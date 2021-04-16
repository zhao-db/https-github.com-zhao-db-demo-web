package com.example.rabbitmq.demorabbitmq.consumer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.rabbitmq.demorabbitmq.dao.VersionHouseApprovalMarket;
import com.example.rabbitmq.demorabbitmq.util.RedisUtil;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;

@Component
public class ConsumerDemo {

    @Autowired
    private RedisUtil redisUtil;

    @RabbitListener(queues = "testQueue")
    public void process(Message message) throws UnsupportedEncodingException {
        System.out.println("开始消费==》》》》");
        byte[] body = message.getBody();
//        List<VersionHouseApprovalMarket> list = JSONArray.parseArray(message.getBody(), VersionHouseApprovalMarket.class);
//        System.out.println(list.toString());
        System.out.println("receive message:{}" + message.getBody());
        byte[] bytes = message.getBody();
        String js = JSONObject.toJSONString(bytes);
        bytes = JSONArray.toJSONBytes(js);
        System.out.println(bytes);

        final Base64.Decoder decoder = Base64.getDecoder();
        bytes = decoder.decode(bytes);

        System.out.println(js);
        System.out.println(bytes);
        redisUtil.del();

        System.out.println("Receiver ====>>>>>>>>" + message);
    }
}

