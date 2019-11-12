package com.ribbitmq.model.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="fanout.message1")
public class FanoutRec1 {

	@RabbitHandler
	public void process(String context) {
		System.out.println("fanout.exchange1 接收信息："+context);
	}
	
}
