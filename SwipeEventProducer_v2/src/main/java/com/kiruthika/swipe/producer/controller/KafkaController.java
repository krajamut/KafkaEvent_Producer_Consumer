package com.kiruthika.swipe.producer.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kiruthika.swipe.producer.SwipeEventProducerApplication;
import com.kiruthika.swipe.producer.config.KafkaPublisher;
import com.kiruthika.swipe.producer.model.SwipeEvents;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@SpringBootApplication
@EnableScheduling
public class KafkaController {
	public static void main(String[] args) {
		SpringApplication.run(SwipeEventProducerApplication.class, args);
	}

	java.lang.String topicName = "quickstart";
	@Qualifier("AvroKafkaPublisher")
	@Autowired
	KafkaPublisher avroPublisher;
	static int eventId = 0;
	String key1;

	@ApiOperation(value = "API by RestTemplate", notes = "fetch AccusedVo Info", nickname = "Avro Producer")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Server error !!!"),
			@ApiResponse(code = 404, message = "Service not found !!!"),
			@ApiResponse(code = 401, message = "Unauthorized access !!!"),
			@ApiResponse(code = 403, message = "Forbidden access !!!"),
			@ApiResponse(code = 200, message = "Successful retrieval !!!", responseContainer = "List") })
	@PostMapping(value = "/send/{key}")
//	@Scheduled(fixedRate = 30000)
	public void sendAvroMessage(
			@ApiParam(value = "Message Key", required = true, defaultValue = "TEST") @PathVariable String key,
			@RequestBody SwipeEvents swipe) {
		com.kiruthika.pojoavro.v2.SwipeEvents avroSwipe = com.kiruthika.pojoavro.v2.SwipeEvents.newBuilder()
				.setEventType(swipe.getEventType()).setDept(swipe.getDept()).setEmpNo(swipe.getEmpNo())
				.setSwipeTime(swipe.getSwipeTime()).build();
		System.out.println("printing seriliazed value" + avroSwipe);
		avroPublisher.sendMessageWithCallback(topicName, key, avroSwipe);
	}

	@PostMapping(value = "/send/start")
	@Scheduled(fixedRate = 30000)
	public void sendAvroMessageBulk() {
		// SwipeEvents swipe = produceMessage30Seconds();
		// System.out.println(produceMessage());
		List<SwipeEvents> swipeEvents = produceMessage();
		swipeEvents.forEach(swipe -> {
			com.kiruthika.pojoavro.v2.SwipeEvents avroSwipe = com.kiruthika.pojoavro.v2.SwipeEvents.newBuilder()
					.setEventType(swipe.getEventType()).setDept(swipe.getDept()).setEmpNo(swipe.getEmpNo())
					.setSwipeTime(swipe.getSwipeTime()).build();
			System.out.println("printing seriliazed value" + avroSwipe);
			avroPublisher.sendMessageWithCallback(topicName, "BULK", avroSwipe);
		});
	}

	public SwipeEvents produceMessage30Seconds() {


		String Dept = "CSS";		
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		
		SwipeEvents swipe1 = new SwipeEvents();
		SwipeEvents swipe2 = new SwipeEvents();
		
		swipe1.setDept("CSS");
		swipe1.setSwipeTime(LocalDateTime.now().plusHours(2).toString());
		swipe1.setEmpNo(number);
		swipe1.setEventType("SwipeIn");
		
		swipe2.setDept("CSS");
		swipe2.setSwipeTime(LocalDateTime.now().plusHours(2).toString());
		swipe2.setEmpNo(number);
		swipe2.setEventType("SwipeIn");
		return swipe1;
	}

	public List<SwipeEvents> produceMessage() {

		List<SwipeEvents> swipeEvents = new ArrayList<SwipeEvents>();
		String Dept = "CSS";		
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		
		SwipeEvents swipe1 = new SwipeEvents();
		SwipeEvents swipe2 = new SwipeEvents();
		
		swipe1.setDept(Dept);
		swipe1.setSwipeTime(LocalDateTime.now().toString());
		swipe1.setEmpNo(number);
		swipe1.setEventType("SwipeIn");
		
		swipe2.setDept(Dept);
		swipe2.setSwipeTime(LocalDateTime.now().plusHours(2).toString());
		swipe2.setEmpNo(number);
		swipe2.setEventType("SwipeOut");
		
		swipeEvents.add(swipe1);
		swipeEvents.add(swipe2);

		return swipeEvents;
	}

	/*
	 * @Scheduled(fixedRate = 30000) public void produceMessage30Seconds() { Swipe
	 * swipe = new Swipe(); swipe.setEventId(++eventId); swipe.setDept("CSS");
	 * Random rnd = new Random(); int number = rnd.nextInt(999999);
	 * swipe.setEmpNo(String.format("%06d", number));
	 * swipe.setSwipeTime(LocalDate.now().toString());
	 * avroPublisher.sendMessageWithCallback(topicName, key1, swipe); }
	 */

}