package com.ribbitmq.model.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="topic.message")
public class TopicMessageRec {

	@RabbitHandler
	public void rec(String context) {
		System.out.println("topic.message 收到信息："+context);
	}
	
}
