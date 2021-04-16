package com.example.rabbitmq.demorabbitmq.productor;

import com.alibaba.fastjson.JSONObject;
import com.example.rabbitmq.demorabbitmq.util.RedisUtil;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ProducerDemo {

    @Autowired
    private RedisUtil redisUtil;

    @Qualifier("rabbitTemplate")
    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("/send")
    public String send(String msg) {
        System.out.println("收到请求，开始发送消息");
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        redisUtil.set(id, msg);
        JSONObject js = new JSONObject();
        js.put("id", id);
        js.put("msg", msg);
        amqpTemplate.convertAndSend("testQueue", js);
        return "success";
    }

}
