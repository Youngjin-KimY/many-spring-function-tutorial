package com.example.jpaproxytutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class JpaProxyTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaProxyTutorialApplication.class, args);
    }

}
