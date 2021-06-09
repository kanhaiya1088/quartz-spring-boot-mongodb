package com.test.spring.scheduler.taskscheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
	
//	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
//
//	@Scheduled(fixedRate = 10000)
//	public void performTask() {
//		System.out.println("Regular task performed at "+ dateFormat.format(new Date()));
//	}
//
//	@Scheduled(initialDelay = 1000, fixedRate = 10000)
//	public void performDelayedTask() {
//		System.out.println("Delayed Regular task performed at "+ dateFormat.format(new Date()));
//	}
//
//	@Scheduled(cron = "*/5 * * * * *")
//	public void performTaskUsingCron() {
//		System.out.println("Regular task performed using Cron at "+ dateFormat.format(new Date()));
//
//	}

	//@Scheduled(cron = "*/2 * * * * ?")
	//@Scheduled(fixedRate = 1000)
	public void cronJobSch() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String strDate = sdf.format(now);
		System.out.println("Java cron job expression:: " + strDate);
	}

}
