package com.example.jpaproxytutorial;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {

    @Async
    public void upload(MultipartFile file) throws InterruptedException {
        System.out.printf("upload service start - currentThread: %s%n",Thread.currentThread());
        Thread.sleep(5000L);
        System.out.printf("upload service end - currentThread: %s%n",Thread.currentThread());
    }
}
