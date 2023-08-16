package com.example.jpaproxytutorial;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class UserService extends CheckGererated {

    public UserService() {
        super("UserService");
    }

    @PostConstruct
    public void checkUserService() {
        System.out.println("===== userService generated =====");
    }

    public UserEntity getUser() {
        return new UserEntity(1L,"hi");
    }
}
