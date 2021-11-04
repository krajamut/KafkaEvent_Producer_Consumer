package com.kiruthika.swipe.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.kiruthika.swipe.consumer.model.SwipeEvents;
import com.kiruthika.swipe.consumer.repo.SwipeRepository;

@Component
public class ConsumerAvroListener {

	@Autowired
	private SwipeRepository swipeRepo;

	@KafkaListener(topics = "quickstart", groupId = "group_id", containerFactory = "kafkaAvroListenerContainerFactory")
	void listenerWithMessageConverter(SwipeEvents swipe) {
		com.kiruthika.swipe.consumer.model.SwipeEvents pojoSwipe = new com.kiruthika.swipe.consumer.model.SwipeEvents();
		pojoSwipe.setDept(swipe.getDept().toString());
		pojoSwipe.setEmpNo(swipe.getEmpNo());
		pojoSwipe.setEventType(swipe.getEventType().toString());
		pojoSwipe.setSwipeTime(swipe.getSwipeTime().toString());
		swipeRepo.save(pojoSwipe);
	}

}