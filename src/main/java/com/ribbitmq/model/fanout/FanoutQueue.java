package com.ribbitmq.model.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName:  FanoutQueue   
 * @Description: 
 * 误区：
 * 	1、bindExchange1、bindExchange2、bindExchange3这三个方法的的参数名，
 * 必须要跟这个类中定义的queueMessage1、queueMessage2、queueMessage3一致。
 * 这个与Springboot中的@Configuration的使用有关。所有的被@Configuration注
 * 释的类，就相当于一个配置文件，@Bean标识的是<bean>标签。参数民，类似于标签内的
 * ref属性。
 * 
 *  2、实现Publish\Subscribe模式。
 *  	a. 一个FanoutExchange转换器
 *  	b. 多个队列
 *  	c. 将多个队列“分别”进行绑定（必须都进行绑定）
 *  
 * @author: renhuibo
 * @date:   2018年11月9日 下午3:54:43
 */
@Configuration
public class FanoutQueue {

	@Bean
	public Queue queueMessage1() {
		return new Queue("fanout.message1");
	}
	
	@Bean
	public Queue queueMessage2() {
		return new Queue("fanout.message2");
	}
	
	@Bean
	public Queue queueMessage3() {
		return new Queue("fanout.message3");
	}
	
	@Bean
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange("fanoutExchange");
	}
	
	@Bean
	public Binding bindExchange1(Queue queueMessage1,FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(queueMessage1).to(fanoutExchange);
	}
	
	@Bean
	public Binding bindExchange2(Queue queueMessage2,FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(queueMessage2).to(fanoutExchange);
	}
	
	@Bean
	public Binding bindExchange3(Queue queueMessage3,FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(queueMessage3).to(fanoutExchange);
	}
	
}
