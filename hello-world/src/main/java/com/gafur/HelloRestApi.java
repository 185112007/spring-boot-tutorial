package com.gafur;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloRestApi {
    @GetMapping
    public String getString(){
        return "Hello, world!";
    }
}
