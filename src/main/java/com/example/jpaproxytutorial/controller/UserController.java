package com.example.jpaproxytutorial.controller;

import com.example.jpaproxytutorial.dao.UserEntity;
import com.example.jpaproxytutorial.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public UserEntity getUser() {
        return userService.getUser();
    }
}
