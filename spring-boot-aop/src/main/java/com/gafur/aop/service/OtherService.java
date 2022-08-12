package com.gafur.aop.service;

import org.springframework.stereotype.Service;

@Service
public class OtherService {
    public void print(String param){
        System.out.println("OtherService: print(" + param + ")");
    }
}
