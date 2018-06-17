package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class SpringAopLoggingApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringAopLoggingApplication.class, args);
		ApplicationContext app = SpringApplication.run(SpringAopLoggingApplication.class, args);//init the context
        Sample myBean = app.getBean(Sample.class);
        myBean.execute();
		
	}
}
