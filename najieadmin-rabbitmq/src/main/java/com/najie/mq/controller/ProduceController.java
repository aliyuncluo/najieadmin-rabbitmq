package com.najie.mq.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.najie.mq.config.ExchangeConfig;

@RestController
public class ProduceController {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@GetMapping("/test/send")
	public String sendMessage() {
		Map<String,Object> map = new HashMap<>();
		map.put("user_id", "123456789");
		map.put("user_name", "张三");
		map.put("user_address", "湖北武汉");
		rabbitTemplate.convertAndSend(ExchangeConfig.EXCHANGE, "user.info", map);
		return "success";
	}
	
	@GetMapping("/test/meeting")
	public String testMeeting() {
		Map<String,Object> map = new HashMap<>();
		map.put("meeting_id", "123456789");
		map.put("meeting_name", "周二晚间会议");
		map.put("meeting_address", "2栋3楼");
		map.put("meeting_time", new Date());
		rabbitTemplate.convertAndSend(ExchangeConfig.EXCHANGE, "meeting.info", map);
		return "success";
	}
}
