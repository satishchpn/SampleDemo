/*package com.idsnext.imagine.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
 
//@SpringBootApplication 
// @SpringBootApplication equivalent to all three
//@SuppressWarnings("unused")
//@EnableAutoConfiguration
@SpringBootApplication 
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.idsnext.imagine.start", "com.idsnext.imagine.setup.api", "com.idsnext.imagine.setup.structures" ,"com.idsnext.imagine.setup.services" })
@EntityScan("com.idsnext.imagine.setup.models")
@EnableJpaRepositories("com.idsnext.imagine.setup.repository")
public class Application {
public static void main(String[] args) {
	ApplicationContext ctx=SpringApplication.run(Application.class, args);
	System.out.println("All Bean Names provided by spring boot......");
	String beanNames[]=ctx.getBeanDefinitionNames();
	for(String name:beanNames){
		System.out.println("Bean Name: "+name);
	}
}
}
*/