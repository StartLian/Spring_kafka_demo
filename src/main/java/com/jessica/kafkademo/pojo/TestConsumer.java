package com.jessica.kafkademo.pojo;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.stereotype.Component;

 

/**

 * 消费者

 */

@Component

public class TestConsumer {

    @KafkaListener(topics = "test")

    public void listen (ConsumerRecord<?, ?> record) throws Exception {

        System.out.println("收到topic 为 test 的消息 ：");

        System.out.printf("topic = %s, offset = %d, value = %s \n", record.topic(), record.offset(), record.value());

    }

}