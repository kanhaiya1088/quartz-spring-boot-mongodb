package com.test.spring.scheduler.taskscheduler.scheduer;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class JobData {
	private String jobName;
	private String jobGroup;
	@JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
	private LocalDateTime startTime;
	private int counter;
	private int gapDuration;

}
