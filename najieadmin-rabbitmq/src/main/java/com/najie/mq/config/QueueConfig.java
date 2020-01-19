package com.najie.mq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {
    //指定队列名称
	public static final String QUEUE_NAME="topic.first";
	//指定会议的队列
	public static final String MEETING_QUEUE="topic.meeting";
	
	@Bean
    public Queue firstQueue(){
        /**
         durable="true" 持久化 rabbitmq重启的时候不需要创建新的队列
         exclusive  表示该消息队列是否只在当前connection生效,默认是false
         auto-delete 表示消息队列没有在使用时将被自动删除 默认是false
         */
        return new Queue(QUEUE_NAME,true,false,false);
    }
	
	@Bean
	public Queue meetingQueue() {
		return new Queue(MEETING_QUEUE,true,false,false);
	}
}
