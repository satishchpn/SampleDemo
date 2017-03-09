package com.zycus.assignment.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value="/test")
public class GreetingController {

	@RequestMapping(value="/greeting")
	public void greeting() {
		System.out.println("Hello");
	}
}