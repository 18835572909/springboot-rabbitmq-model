package com.ribbitmq.model.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="topic.messages")
public class TopicMessagesRec {

	@RabbitHandler
	public void say(String context) {
		System.out.println("topic.messages 收到信息："+context);
	}
	
}
