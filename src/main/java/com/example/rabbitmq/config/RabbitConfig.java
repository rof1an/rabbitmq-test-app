package com.example.rabbitmq.config;

import com.example.rabbitmq.Receiver;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitConfig {

    public static final String queueName1 = "topic_1";
    public static final String queueName2 = "topic_2";

    @Bean
    public Queue queue1() {
        return new Queue(queueName1, false);
    }

    @Bean
    public Queue queue2() {
        return new Queue(queueName2, false);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }

    @Bean
    public SimpleMessageListenerContainer listenerContainer(ConnectionFactory connectionFactory,
                                                            MessageListenerAdapter listenerAdapter1) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName1);
        container.setMessageListener(listenerAdapter1);
        return container;
    }

    @Bean
    public SimpleMessageListenerContainer listenerContainer2(ConnectionFactory connectionFactory,
                                                             MessageListenerAdapter listenerAdapter2) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName2);
        container.setMessageListener(listenerAdapter2);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter1(Receiver receiver) {
        return new MessageListenerAdapter(receiver);
    }

    @Bean
    MessageListenerAdapter listenerAdapter2(Receiver receiver) {
        return new MessageListenerAdapter(receiver);
    }
}
