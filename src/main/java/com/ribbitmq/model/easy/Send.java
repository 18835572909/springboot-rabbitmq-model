package com.ribbitmq.model.easy;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Send {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public void process(String sendContext) {
		amqpTemplate.convertSendAndReceive("easy1", sendContext);
	}
	
}
