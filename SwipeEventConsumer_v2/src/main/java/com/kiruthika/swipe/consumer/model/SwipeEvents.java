package com.kiruthika.swipe.consumer.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "swipeentries")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SwipeEvents {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private String id;
	private String eventType;
	private int empNo;
	private String dept;
	private String swipeTime;

}
