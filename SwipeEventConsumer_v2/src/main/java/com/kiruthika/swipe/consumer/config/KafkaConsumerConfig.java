package com.kiruthika.swipe.consumer.config;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import com.kiruthika.pojoavro.v2.SwipeEvents;
import com.kiruthika.swipe.consumer.repo.SwipeRepository;
import com.kiruthika.swipe.producer.deserializer.AvroDeserializer;

import lombok.extern.slf4j.Slf4j;

@Order(1)
@Slf4j
@Configuration("KafkaAvroConsumerConfig")
public class KafkaConsumerConfig {
	@Autowired
	private SwipeRepository swipeRepo;

	public Map<String, Object> consumerConfigs() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, AvroDeserializer.class);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");

		return props;
	}

	@Bean("AvroConsumerFactory")
	public ConsumerFactory<String, SwipeEvents> consumerFactory() {
		// return new DefaultKafkaConsumerFactory<>(consumerConfigs());
		return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),
				new AvroDeserializer<>(SwipeEvents.class));

	}

	@Bean("kafkaAvroListenerContainerFactory")
	public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, SwipeEvents>> kafkaListenerContainerFactory(
			@Qualifier("AvroConsumerFactory") ConsumerFactory<String, SwipeEvents> consumerFactory) {
		ConcurrentKafkaListenerContainerFactory<String, SwipeEvents> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory);
		factory.setRecordFilterStrategy(record -> {
			log.info("Filtering the message >>" + record.value());
			com.kiruthika.swipe.consumer.model.SwipeEvents pojoSwipe = new com.kiruthika.swipe.consumer.model.SwipeEvents();
			UUID uuid = UUID.randomUUID();
			pojoSwipe.setId(uuid.toString());
			pojoSwipe.setDept(record.value().getDept().toString());
			pojoSwipe.setEmpNo(record.value().getEmpNo());
			pojoSwipe.setEventType(record.value().getEventType().toString());
			pojoSwipe.setSwipeTime(record.value().getSwipeTime().toString());
			// System.out.println(pojoSwipe + "pojo object");
			swipeRepo.save(pojoSwipe);
			return record.value().getDept().toString().equalsIgnoreCase("CSS");
		});
		return factory;
	}

}
