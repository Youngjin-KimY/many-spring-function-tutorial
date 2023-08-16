package com.example.jpaproxytutorial.controller;

import com.example.jpaproxytutorial.component.AsyncUpload;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.CompletableFuture;

@RestController
public class UploadController {
    AsyncUpload asyncUpload;

    public UploadController(AsyncUpload asyncUpload) {
        this.asyncUpload = asyncUpload;
    }

    @RequestMapping(path="upload", method = RequestMethod.POST)
    public CompletableFuture<String> upload(MultipartFile file) throws InterruptedException {
        System.out.printf("controller currentThread: %s%n",Thread.currentThread());
        return asyncUpload.upload(file);
    }
}
