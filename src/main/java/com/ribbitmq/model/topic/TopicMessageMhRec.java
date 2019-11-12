package com.ribbitmq.model.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="topic.message.mh")
public class TopicMessageMhRec {

	@RabbitHandler
	public void process(String context) {
		System.out.println("topic.message.mh 收到信息："+context);
	}
	
}
