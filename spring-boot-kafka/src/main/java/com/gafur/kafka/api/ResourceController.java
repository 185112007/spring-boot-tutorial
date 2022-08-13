package com.gafur.kafka.api;

import com.gafur.kafka.dto.KMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping ("/api/kafka")
@RestController
public class ResourceController {
    private final KafkaTemplate kafkaTemplate;

    public ResourceController(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public String sentMessage(@RequestBody KMessage message) {
        this.kafkaTemplate.send("transaction-1", new KMessage(message.getMessage()));

        return "Hello World!";
    }
}
