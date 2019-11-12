package com.ribbitmq.model.easy;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="easy1")
public class Rec {
	
	@RabbitHandler
	public void say(String context) {
		System.out.println("easy1 rec1 : "+context);
	}
	
}
