package com.example.rabbitmq;

import com.example.rabbitmq.config.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private final RabbitTemplate rabbitTemplate;

    public Producer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(RabbitConfig.queueName1, message);
    }

    public void sendAnswer(String message) {
        rabbitTemplate.convertAndSend(RabbitConfig.queueName2, message);
    }
}
