package com.test.spring.scheduler.taskscheduler.service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.spring.scheduler.taskscheduler.model.Fruits;
import com.test.spring.scheduler.taskscheduler.repository.FruitsRepository;
import com.test.spring.scheduler.taskscheduler.scheduer.JobData;
import com.test.spring.scheduler.taskscheduler.scheduer.ScheduledJob;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GlobalRestService {

	@Autowired
	private FruitsRepository fruitsRepository;
	
	@Autowired
	private Scheduler quartzScheduler;
	
	@PostConstruct
	public void postContruct() { 
		
		try {
			quartzScheduler.start();
		} catch (SchedulerException exception) {
			System.out.println("scheduler thorws exception "+exception);
		}
	}
	
	@PreDestroy
	public void preDestroy() { 
		try { 
			quartzScheduler.shutdown(); 
		} catch (SchedulerException exception) {
		  System.out.println("scheduler thorws exception "+exception); 
		} 
	}

	public Fruits saveFruit(Fruits fruit) {
		Fruits savedFruit = fruitsRepository.save(fruit);
		return savedFruit;
	}

	public List<Fruits> findAllFruits() {
		List<Fruits> allFruits = fruitsRepository.findAll();
		return allFruits;
	}

	public void deleteFruit(String fruitId) {
		Optional<Fruits> fruit = fruitsRepository.findById(fruitId);
		if (fruit.isPresent())
			fruitsRepository.delete(fruit.get());
	}

	public Integer countByFruitName(String fruitName) {
		Integer count = fruitsRepository.countByFruitName(fruitName);
		return count;
	}
	
	public void schedule(JobData data) {
		String jobName = data.getJobName();
		String jobGroup = data.getJobGroup();
		
		int counter = data.getCounter();
		int gapDuration = data.getGapDuration();
		
		ZonedDateTime zonedDateTime = ZonedDateTime.of(data.getStartTime(), ZoneId.of("Asia/Kolkata"));
		
		JobDataMap dataMap = new JobDataMap();
		dataMap.put("test", "this is just for demo"); 
		
		JobDetail detail = JobBuilder.newJob(ScheduledJob.class)
				.withIdentity(jobName, jobGroup).usingJobData(dataMap).storeDurably(false)
				.build();
		
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName, jobGroup)
				.startAt(Date.from(zonedDateTime.toInstant()))
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMinutes(gapDuration).withRepeatCount(counter))
				.build();
		
		try {
			quartzScheduler.scheduleJob(detail, trigger);
		} catch (SchedulerException exception) {
			exception.printStackTrace();
		}
	}

}
