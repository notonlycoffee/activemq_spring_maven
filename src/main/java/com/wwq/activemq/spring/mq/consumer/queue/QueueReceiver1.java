package com.wwq.activemq.spring.mq.consumer.queue;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by Administrator on 2016/11/17.
 */
@Component
public class QueueReceiver1 implements MessageListener{

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("TopicReceiver1接收到信息" + ((TextMessage) message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
