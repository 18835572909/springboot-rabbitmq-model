package com.ribbitmq.model.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName:  TopicMessageSend   
 * @Description:
 * 1. 所有的插件操作（发送\接收），充当工具类
 * 2. 引入AmqpTemplete(发送端对外提供的对象)
 * 3. 重点说一下amqpTemplete.convertAndSend()方法：
 * 		convertAndSend(String,Object)  //不使用转换器Exchange实现队列中信息的发布
 * 		convertAndSend(String,String,Object) //队列绑定转换器，实现队列信息的发布
 * 
 * 发送send1会匹配到topic.#和topic.message 两个Receiver都可以收到消息;
 * 发送send2只有topic.#可以匹配所有只有Receiver2监听到消息
 * 
 * @author: renhuibo
 * @date:   2018年11月9日 上午10:29:44
 */
@Component
public class TopicMessageSend {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public void process(String context) {
		System.out.println("message发送内容："+context);
		amqpTemplate.convertAndSend("exchange", "topic.message", context);
	}
	
	public void processMessages(String context) {
		System.out.println("messages发送内容："+context);
		amqpTemplate.convertAndSend("exchange", "topic.messages", context);
	}
	
	public void processMessagemh(String context) {
		System.out.println("messagesmh发送内容："+context);
		amqpTemplate.convertAndSend("exchange", "topic.message.mh", context);
	}
	
}
