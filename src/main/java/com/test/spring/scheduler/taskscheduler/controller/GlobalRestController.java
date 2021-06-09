package com.test.spring.scheduler.taskscheduler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.spring.scheduler.taskscheduler.model.Fruits;
import com.test.spring.scheduler.taskscheduler.scheduer.JobData;
import com.test.spring.scheduler.taskscheduler.service.GlobalRestService;

@RestController
public class GlobalRestController {

	@Autowired
	private GlobalRestService globalRestService;

	@PostMapping("/fruits")
	public ResponseEntity<Fruits> saveFruit(@RequestBody Fruits fruit) {
		Fruits savedFruit = globalRestService.saveFruit(fruit);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedFruit);
	}

	@GetMapping("/fruits")
	public ResponseEntity<List<Fruits>> findAllFruits() {
		List<Fruits> allFruits = globalRestService.findAllFruits();
		return ResponseEntity.status(HttpStatus.OK).body(allFruits);
	}

	@GetMapping("/fruits/count/{name}")
	public ResponseEntity<Integer> countByNameFruits(@PathVariable String name) {
		Integer count = globalRestService.countByFruitName(name);
		return ResponseEntity.status(HttpStatus.OK).body(count);

	}

	@DeleteMapping("/fruits/{fruitId}")
	public ResponseEntity<Void> deleteByFruitId(@PathVariable String fruitId) {
		globalRestService.deleteFruit(fruitId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	@PostMapping("/schedule")
	public ResponseEntity<Void> schedule(@RequestBody JobData jobData) {
		globalRestService.schedule(jobData);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

}
