package com.gafur.api;

import com.gafur.entity.User;
import com.gafur.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/{search}")
    public ResponseEntity<List<User>> getUser(@PathVariable String search){
        List<User> users = userRepository.findByName(search);
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.ok(userRepository.save(user));
    }
}
