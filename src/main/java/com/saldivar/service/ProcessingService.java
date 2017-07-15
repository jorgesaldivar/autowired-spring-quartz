package com.saldivar.service;

/**
 * Simple interface so this interface can be used so spring can autowire the
 * implementation
 * 
 * @author saldivar
 *
 */
public interface ProcessingService {

	void process(String origin);

}
