package com.kiruthika.swipe.consumer.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kiruthika.swipe.consumer.model.SwipeEvents;



public interface SwipeRepository extends MongoRepository<SwipeEvents,Integer>{

	List<SwipeEvents> findByEmpNo(int empNo);
	

}
