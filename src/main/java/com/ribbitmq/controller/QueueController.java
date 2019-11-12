package com.ribbitmq.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ribbitmq.model.easy.Send;
import com.ribbitmq.model.fanout.FanoutSend;
import com.ribbitmq.model.topic.TopicMessageSend;

@Controller
@RestController
@RequestMapping(value="/queue")
public class QueueController {

	@Autowired
	private Send send;
	
	@Autowired
	private TopicMessageSend topicSend;
	
	@Autowired
	private FanoutSend fanoutSend;
	
	@RequestMapping("/onetoone")
	public String easyQueueOneToOne() {
		for(int i=0;i<10;i++) {
			send.process(new Date()+"-->"+"Fuck you,Bitch!");
		}
		return "发送完毕！";
	}
	
	@RequestMapping("/topic")
	public String topicQueue() {
		for(int i=0;i<10;i++) {
			topicSend.process(new Date()+"-->"+"Fuck you,Bitch!");
		}
		return "发送完毕！";
	}
	
	@RequestMapping("/topicmessages")
	public String topicQueues() {
		for(int i=0;i<10;i++) {
			topicSend.processMessages(new Date()+"-->"+"Fuck you,Bitch!");
		}
		return "发送完毕！";
	}
	
	@RequestMapping("/topicmessagemh")
	public String topicQueuemh() {
		for(int i=0;i<10;i++) {
			topicSend.processMessagemh(new Date()+"-->"+"Fuck you,Bitch!");
		}
		return "发送完毕！";
	}
	
	@RequestMapping("/fanout")
	public String fanoutQueue() {
		for(int i=0;i<10;i++) {
			fanoutSend.process(new Date()+"-->"+"Fuck you,Bitch!");
		}
		return "发送完毕！";
	}
}
