package com.ddoong2.customrepository.controller;

import com.ddoong2.customrepository.entity.UserEntity;
import com.ddoong2.customrepository.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/user/{name}")
    public UserEntity findAll(@PathVariable("name") String name) {

        return userRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException());
    }

    @GetMapping("/user/age/{age}")
    public UserEntity findByAge(@PathVariable("age") Integer age) {

        return userRepository.findByAge(age)
                .orElseThrow(() -> new RuntimeException());
    }

}
