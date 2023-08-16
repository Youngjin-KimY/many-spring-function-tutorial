package com.example.jpaproxytutorial.controller;

import com.example.jpaproxytutorial.component.GreetingMessageSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    private GreetingMessageSender greetingMessageSender;

    public LoginController(GreetingMessageSender greetingMessageSender) {
        this.greetingMessageSender = greetingMessageSender;
    }

    @RequestMapping(value = "/picture/qr", method = RequestMethod.GET)
    public Boolean pictureLoginQr() {
        greetingMessageSender.changeQrStatus();
        return true;
    }
}
