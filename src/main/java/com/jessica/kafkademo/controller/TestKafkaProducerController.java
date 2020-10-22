package com.jessica.kafkademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

@RequestMapping("/kafka")
public class TestKafkaProducerController {
	@Autowired

    private KafkaTemplate<String,String> kafkaTemplate;

    @RequestMapping("/send/{msg}")

    public String send (@PathVariable String msg) {

        System.out.println("发送消息 topic test 内容："+msg);

        ListenableFuture<SendResult<String,String>> future = kafkaTemplate.send("test", msg);

        return "success";

    }
}
