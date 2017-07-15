package com.saldivar.scheduler;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.saldivar.scheduler.QuartzScheduling;
import com.saldivar.service.ProcessingService;

public class QuartzSchedulingTest {

	private ProcessingService mockProcessingService;
	private JobExecutionContext mockJobExecutionContext;
	private QuartzScheduling quartzScheduling;

	@Before
	public void setup() {
		mockProcessingService = mock(ProcessingService.class);
		mockJobExecutionContext = mock(JobExecutionContext.class);
		quartzScheduling = new QuartzScheduling();
		quartzScheduling.setProcessingService(mockProcessingService);
	}

	@Test
	public void testExecuteInternal_ReachProcessMethod() throws JobExecutionException {

		// Setup
		doNothing().when(mockProcessingService).process(anyString());

		// Execution
		quartzScheduling.executeInternal(mockJobExecutionContext);

		// Validation
		Mockito.verify(mockProcessingService, Mockito.times(1)).process(anyString());

	}

}
