package com.example.jpaproxytutorial.component;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class GreetingMessageSender {

    private boolean isQr;

    public GreetingMessageSender() {
        this.isQr = false;
    }

    @Async
    public void send(SseEmitter emitter) throws InterruptedException, IOException {


        emitter.send(SseEmitter.event().id(UUID.randomUUID().toString())
                .data("take picture QR!"));
        TimeUnit.SECONDS.sleep(1);

//        emitter.send(SseEmitter.event().id(UUID.randomUUID().toString())
//                .data("hello!"));
//        TimeUnit.SECONDS.sleep(1);
//
//        emitter.send(SseEmitter.event().id(UUID.randomUUID().toString())
//                .data("good night"));
//        TimeUnit.SECONDS.sleep(1);
        waitForQr();

        if(this.isQr) {
            emitter.send(SseEmitter.event().id(UUID.randomUUID().toString())
                    .data("token: 12345"));
        }
        else {
            emitter.send(SseEmitter.event().id(UUID.randomUUID().toString())
                    .data("fail login"));
        }


        emitter.complete();
    }

    private final Object lock = new Object();

    public void waitForQr() throws InterruptedException {
        int sec = 1;
        synchronized (lock) {
            long endTime = System.currentTimeMillis() + 60000;
            while(!this.isQr && System.currentTimeMillis() < endTime) {
                System.out.printf("Waiting for qr %s%n",sec);
                lock.wait(1000);
                sec++;
            }
        }
    }

    public void changeQrStatus() {
        this.isQr = true;
    }
}
