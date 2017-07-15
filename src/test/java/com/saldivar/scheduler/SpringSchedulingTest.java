package com.saldivar.scheduler;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.saldivar.service.ProcessingService;

public class SpringSchedulingTest {

	private ProcessingService mockProcessingService;
	private SpringScheduling springScheduling;

	@Before
	public void setup() {
		mockProcessingService = mock(ProcessingService.class);
		springScheduling = new SpringScheduling();
		springScheduling.setProcessingService(mockProcessingService);
	}

	@Test
	public void testGetTimeEveryTenSeconds_ReachProcessMethod() {

		// Setup
		doNothing().when(mockProcessingService).process(anyString());

		// Execution
		springScheduling.getTimeEveryTenSeconds();

		// Validation
		Mockito.verify(mockProcessingService, Mockito.times(1)).process(anyString());

	}

}
