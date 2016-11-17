package com.wwq.activemq.spring.controller;

import com.wwq.activemq.spring.mq.producer.queue.QueueSender;
import com.wwq.activemq.spring.mq.producer.topic.TopicSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/11/17.
 */
@Controller
@RequestMapping("/activemq")
public class ActivemqController {

    @Resource
    QueueSender queueSender;
    @Resource
    TopicSender topicSender;


    @ResponseBody
    @RequestMapping("queueSender")
    public String queueSender(@RequestParam("message") String message) {
        String opt = "";
        try {
            queueSender.send("test.queue", message);
            opt = "suc";
        } catch (Exception e) {
            opt = e.getCause().toString();
        }
        return opt;
    }


    @ResponseBody
    @RequestMapping("topicSender")
    public String topicSender(@RequestParam("message") String message) {
        String opt = "";
        try {
            topicSender.send("test.topic",message);
        } catch (Exception e) {
            opt = e.getCause().toString();
        }
        return opt;
    }
}




