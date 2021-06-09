package com.test.spring.scheduler.taskscheduler.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.spring.scheduler.taskscheduler.model.Fruits;

public interface FruitsRepository extends MongoRepository<Fruits, String>{
	
	public Integer countByFruitName(String fruitName);

}
