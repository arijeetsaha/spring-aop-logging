package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Sample {

	@Autowired
	private SampleService service;

	public void execute() {
		service.beforeExecute();
		service.getName("The Great");

		service.get1Method();
		service.get2Method();
		service.get3Method();

		try {
			service.throwException();
		} catch (Exception e) {

		}
	}
}
