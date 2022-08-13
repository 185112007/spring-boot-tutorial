package com.gafur.kafka.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.UUID;

public class KMessage {
    private String message;
    private String id;
    private LocalDate messageDate;

    public KMessage() {
        id = UUID.randomUUID().toString();
        messageDate = LocalDate.now();
    }

    public KMessage(@JsonProperty String message) {
        this();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(LocalDate messageDate) {
        this.messageDate = messageDate;
    }

    @Override
    public String toString() {
        return "KMessage{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                ", messageDate=" + messageDate +
                '}';
    }
}
