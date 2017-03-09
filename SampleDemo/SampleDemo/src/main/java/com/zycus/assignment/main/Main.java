package com.zycus.assignment.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.zycus.assignment")
@EntityScan("com.zycus.assignment.model")
public class Main extends SpringBootServletInitializer {
	public static void main(String[] args) {
		System.out.println("Application Starting....");
		SpringApplication.run(Main.class, args);
		System.out.println("Application Started....");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Main.class);
	}
}