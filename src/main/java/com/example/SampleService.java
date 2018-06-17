package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SampleService.class);

	@LogAnnotation
	public void beforeExecute() {
		LOGGER.debug("Executing method");
	}

	@LogAnnotation
	public String getName(String name) {
		return "Alexander "+ name;
	}

	@CommonAnnotation
	public void get1Method() {
		LOGGER.debug("CommonAnnotation - get1Method method");
	}

	@CommonAnnotation
	public void get2Method() {
		LOGGER.debug("CommonAnnotation - get1Method method");
	}

	@CommonAnnotation
	public String get3Method() {
		return "Narendra Modi";
	}

	public void throwException() throws Exception {
		LOGGER.debug("Throw Exception -  SampleService");
		throw new Exception();
	}
}
