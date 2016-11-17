package com.wwq.activemq.spring.mq.consumer.topic;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.awt.font.TextMeasurer;

/**
 * Created by Administrator on 2016/11/17.
 */
@Component
public class TopicReceiver1 implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("TopicReceiver1接收到信息" + ((TextMessage) message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
