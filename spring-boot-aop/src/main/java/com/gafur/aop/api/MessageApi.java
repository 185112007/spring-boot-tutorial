package com.gafur.aop.api;

import com.gafur.aop.service.MessageService;
import com.gafur.aop.service.OtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageApi {

    @Autowired
    private MessageService messageService;

    @Autowired
    private OtherService otherService;

    @PostMapping
    public ResponseEntity<String> listAll(@RequestBody String message){
        otherService.print(message);
        return ResponseEntity.ok(messageService.getMessage(message));
    }
}
