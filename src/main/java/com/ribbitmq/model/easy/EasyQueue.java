package com.ribbitmq.model.easy;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EasyQueue {

	@Bean
	public Queue easy1() {
		return new Queue("easy1");
	}
 	
	@Bean
	public Queue easy2() {
		return new Queue("easy2");
	}
	
}
