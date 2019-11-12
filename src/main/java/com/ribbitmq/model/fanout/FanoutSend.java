package com.ribbitmq.model.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSend {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public void process(String context) {
		System.out.println("fanout.exchange 发送信息："+context);
		amqpTemplate.convertAndSend("fanoutExchange","",context);;
	}
	
}
