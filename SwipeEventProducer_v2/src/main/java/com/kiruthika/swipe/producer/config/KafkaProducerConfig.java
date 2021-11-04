package com.kiruthika.swipe.producer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
//import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
//import com.kiruthika.pojoavro.model.Swipe;
import com.kiruthika.pojoavro.v2.SwipeEvents;
import com.kiruthika.swipe.producer.serializer.AvroSerializer;

import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;

@Order(1)
@Configuration("AvroKafkaProducerConfig")
public class KafkaProducerConfig {

	private String bootstrapServers = "localhost:9092";

	@Bean
	public Map<String, Object> producerConfigs() {
		Map<String, Object> props = new HashMap<>();
		props.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, 1);
		// Set the number of retries - retries
		props.put(ProducerConfig.RETRIES_CONFIG, 3);

		// Request timeout - request.timeout.ms
		props.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, 15_000);

		// Only retry after one second.
		props.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, 1_000);

		props.put(ProducerConfig.ACKS_CONFIG, "-1");

		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, AvroSerializer.class);
		props.put(AbstractKafkaSchemaSerDeConfig.AUTO_REGISTER_SCHEMAS, Boolean.FALSE);
		props.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "not-used");

		return props;
	}

	@Bean("AvroProducerFactory")
	public ProducerFactory<String, SwipeEvents> producerFactory() {
		return new DefaultKafkaProducerFactory<>(producerConfigs());
	}

	@Bean("AvroKafkaTemplate")
	public KafkaTemplate<String, SwipeEvents> kafkaTemplate(
			@Qualifier("AvroProducerFactory") ProducerFactory<String, SwipeEvents> producerFactory) {
		return new KafkaTemplate<>(producerFactory);
	}

}