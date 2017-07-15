package com.saldivar.scheduler;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.saldivar.config.AutowiringSpringBeanJobFactory;
import com.saldivar.service.ProcessingService;

/**
 * Simple quartz job. This job has been autowired to use spring annotations with
 * the help of {@link AutowiringSpringBeanJobFactory}
 * 
 * @author saldivar
 *
 */
public class QuartzScheduling extends QuartzJobBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(QuartzScheduling.class);
	private ProcessingService processingService;

	@Autowired
	public void setProcessingService(ProcessingService processingService) {
		this.processingService = processingService;
	}

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		LOGGER.info("Date: {}", new Date());
		processingService.process(this.getClass().getName());
	}

}
