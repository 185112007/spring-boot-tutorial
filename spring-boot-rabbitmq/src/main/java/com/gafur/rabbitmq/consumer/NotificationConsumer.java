package com.gafur.rabbitmq.consumer;

import com.gafur.rabbitmq.model.Notification;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @RabbitListener(queues = "queue-name")
    public void handleMessage(Notification notification){
        System.out.println("Message received.");
        System.out.println(notification);
    }
}
