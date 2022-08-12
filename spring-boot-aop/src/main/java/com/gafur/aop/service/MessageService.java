package com.gafur.aop.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String getMessage(String param){
        System.out.println("getMessage(" + param + ")");
        return param;
    }
}
