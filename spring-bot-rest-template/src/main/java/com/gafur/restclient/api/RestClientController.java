package com.gafur.restclient.api;

import com.gafur.restclient.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/test")
public class RestClientController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String URL = "http://localhost:8081/user";

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll(){
        ResponseEntity<List> objectList = restTemplate.<List>getForEntity(URL, List.class);
        return ResponseEntity.ok(objectList.getBody());
    }

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto){
        return restTemplate.postForEntity(URL,userDto, UserDto.class);
    }
}
