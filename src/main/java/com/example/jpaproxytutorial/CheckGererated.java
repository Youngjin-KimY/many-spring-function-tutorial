package com.example.jpaproxytutorial;

import jakarta.annotation.PostConstruct;

public abstract class CheckGererated {

    private String name;

    public CheckGererated(String name) {
        this.name = name;
    }

    @PostConstruct
    public void checkGeneratedFinish() {
        System.out.println(String.format("===== %s gen finish =====", this.name));
    }
}
