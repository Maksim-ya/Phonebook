package com.lardi.phonebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class PhoneBook extends  SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PhoneBook .class, args);
	}

}

//@SpringBootApplication
//public class Application extends SpringBootServletInitializer {
//
//	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args)
//				.registerShutdownHook();
//	}
//
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(Application.class);
//	}
//}