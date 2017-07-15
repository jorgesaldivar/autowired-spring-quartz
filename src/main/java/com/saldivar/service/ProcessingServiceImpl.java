package com.saldivar.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Simple {@link ProcessingService} implementation
 * 
 * @author saldivar
 *
 */
@Service
public class ProcessingServiceImpl implements ProcessingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessingServiceImpl.class);
	private String origin;

	@Override
	public void process(String origin) {
		this.origin = origin;
		start();
		terminate();
	}

	public void start() {
		LOGGER.info("Processing has been started for: {}", origin);
	}

	public void terminate() {
		LOGGER.info("Processing has been terminated successfully for {}", origin);
	}

}