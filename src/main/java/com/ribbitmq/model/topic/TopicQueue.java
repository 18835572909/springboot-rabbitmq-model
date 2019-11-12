package com.ribbitmq.model.topic;

import org.slf4j.Logger;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName:  TopicQueue   
 * @Description:
 * 	topic模型的Exchange,实现注意点
 * 1.队列，命名
 * 2.单个转换器，命名
 * 3.绑定器 ，对队列绑定转换器，使用routing_key发布信息
 * @author: renhuibo
 * @date:   2018年11月9日 上午10:15:26
 */
@Configuration
public class TopicQueue {

	@Bean
	public Queue queueMessage() {
		return new Queue("topic.message");
	}
	
	@Bean
	public Queue queueMessages() {
		return new Queue("topic.messages");
	}
	
	@Bean
	public Queue queueMessagemh() {
		return new Queue("topic.message.mh");
	}
	
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange("exchange");
	}
	
	/**
	 * @Description:指定绑定
	 * @date:   2018年11月9日 上午10:25:26   
	 * @param queueMessage
	 * @param topicExchange
	 * @return
	 */
	@Bean
	public Binding bindingExchangeMessage(Queue queueMessage,TopicExchange topicExchange) {
		return BindingBuilder.bind(queueMessage).to(topicExchange).with("topic.message");
	}
	
	/**
	 * @Description:模糊绑定   
	 * @date:   2018年11月9日 上午10:25:54   
	 * @param queueMessages
	 * @param topicExchange
	 * @return
	 */
	@Bean
	public Binding bingExchangeMessages(Queue queueMessages,TopicExchange topicExchange) {
		System.out.println(queueMessages.getName()+"--"+topicExchange.getName());
		return BindingBuilder.bind(queueMessages).to(topicExchange).with("topic.message.#");
	}
	
	@Bean
	public Binding bingExchangeMessages2(Queue queueMessagemh,TopicExchange topicExchange) {
		System.out.println(queueMessagemh.getName()+"--"+topicExchange.getName());
		return BindingBuilder.bind(queueMessagemh).to(topicExchange).with("topic.message.#");
	}
	
}
