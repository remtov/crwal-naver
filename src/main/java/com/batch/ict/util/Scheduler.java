package com.batch.ict.util;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
	@Scheduled(initialDelay = 0, fixedRate = 600000)
	public void simplePrintln() {
		System.out.println(new Date());
	}

	@Bean
	public TaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(5);
		return taskExecutor;
	}
}
