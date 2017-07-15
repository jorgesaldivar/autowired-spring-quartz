package com.saldivar.scheduler;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.saldivar.service.ProcessingService;

/**
 * Simple spring scheduler
 * 
 * @author saldivar
 *
 */
@Component
public class SpringScheduling {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringScheduling.class);
	private ProcessingService processingService;

	@Autowired
	public void setProcessingService(ProcessingService processingService) {
		this.processingService = processingService;
	}

	@Scheduled(cron = "*/10 * * * * *")
	public void getTimeEveryTenSeconds() {
		LOGGER.info("Date: {}", new Date());
		processingService.process(this.getClass().getName());
	}

}
