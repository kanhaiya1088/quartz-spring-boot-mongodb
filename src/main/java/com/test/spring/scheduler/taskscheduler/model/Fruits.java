package com.test.spring.scheduler.taskscheduler.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "fruits")
public class Fruits {
	
	@Id
	private String id;
	
	private String fruitName;

}
