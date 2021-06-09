package com.test.spring.scheduler.taskscheduler.scheduer;

import java.util.List;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import com.test.spring.scheduler.taskscheduler.model.Fruits;
import com.test.spring.scheduler.taskscheduler.repository.FruitsRepository;

@Component
public class ScheduledJob extends QuartzJobBean {

	@Autowired
	private FruitsRepository fruitsRepository;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		JobDataMap mergedJobDataMap = context.getMergedJobDataMap();
		for (String key : mergedJobDataMap.getKeys()) {
			System.out.println(" from scheduled job :: " + mergedJobDataMap.get(key));
		}

//		List<Fruits> fruitList = fruitsRepository.findAll();
//		for (Fruits fruit : fruitList) {
//			System.out.println(" fruit = " + fruit.getFruitName() + " and count is " + fruitsRepository.countByFruitName(fruit.getFruitName()));
//		}

	}

}
