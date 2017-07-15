package com.saldivar;

import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("resource")
public class MainApp {

	private MainApp() {		
	}
	
	public static void main(String[] args) {

		new ClassPathXmlApplicationContext("applicationContext.xml");

	}

}
