package com.wwq.activemq.spring.mq.producer.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by Administrator on 2016/11/17.
 */
@Component("topicSender")
public class TopicSender {

    @Autowired
    @Qualifier("jmsTopicTemplate")
    private JmsTemplate jmsTemplate;

    public void send(String topicName, final String message) {
        jmsTemplate.send(topicName, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }
}
