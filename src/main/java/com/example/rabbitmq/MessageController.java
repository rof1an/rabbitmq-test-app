package com.example.rabbitmq;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
public class MessageController {

    private final Producer producer;

    public MessageController(Producer producer) {
        this.producer = producer;
    }

    @GetMapping("/message")
    public String sendMessage() {
        producer.sendMessage("hello PR");
        return "hello PR";
    }

    @GetMapping("/answer")
    public String sendAnswer() {
        producer.sendAnswer("answer C to PR");
        return "answer C to PR";
    }
}
