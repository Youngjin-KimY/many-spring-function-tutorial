package com.example.jpaproxytutorial.controller;

import com.example.jpaproxytutorial.component.GreetingMessageSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@RestController
public class ServerSentEventController {

    private final GreetingMessageSender greetingMessageSender;

    public ServerSentEventController(GreetingMessageSender greetingMessageSender) {
        this.greetingMessageSender = greetingMessageSender;
    }

    @RequestMapping(path="greeting", method = RequestMethod.GET)
    public SseEmitter greeting() throws IOException, InterruptedException {
        SseEmitter emitter = new SseEmitter(70000L);

        greetingMessageSender.send(emitter);
        return emitter;
    }
}
