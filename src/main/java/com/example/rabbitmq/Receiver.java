package com.example.rabbitmq;

import org.springframework.stereotype.Component;

@Component
public class Receiver {

    public void receive1(String message) {
        System.out.println("Received Message: " + message);
    }

    public void receive2(String message) {
        System.out.println("Received Message: " + message);
    }
}
