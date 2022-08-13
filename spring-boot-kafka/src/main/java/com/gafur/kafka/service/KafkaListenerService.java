package com.gafur.kafka.service;

import com.gafur.kafka.api.ResourceController;
import com.gafur.kafka.dto.KMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaListenerService {
    private final Logger logger = LoggerFactory.getLogger(KafkaListenerService.class);

    @KafkaListener(topics = "transaction-1")
    public void listener(@Payload KMessage message, ConsumerRecord<String, KMessage> cr) {
        logger.info("Message received.. MessageID : {} Message: {} Date : {}",
                message.getId(),
                message.getMessage(),
                message.getMessageDate());
        logger.info(cr.toString());
    }
}
