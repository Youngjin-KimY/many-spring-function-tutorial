package com.example.jpaproxytutorial.component;

import com.example.jpaproxytutorial.service.UploadService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.CompletableFuture;

@Component
public class AsyncUpload {

    UploadService uploadService;

    public AsyncUpload(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @Async
    public CompletableFuture<String> upload(MultipartFile file) throws InterruptedException {
        System.out.printf("Async upload start - currentThread: %s%n",Thread.currentThread());

        uploadService.upload(file);

        System.out.printf("Async upload end - currentThread: %s%n",Thread.currentThread());
        return CompletableFuture.completedFuture("upload/complete");
    }
}
