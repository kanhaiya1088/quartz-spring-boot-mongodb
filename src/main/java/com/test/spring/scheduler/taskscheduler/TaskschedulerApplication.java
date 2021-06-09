package com.test.spring.scheduler.taskscheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling
public class TaskschedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskschedulerApplication.class, args);
	}

}
