package com.example.jpaproxytutorial;

import jakarta.persistence.*;

@Entity
@Table(name = "user_table")
public class UserEntity extends CheckGererated {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public UserEntity() {
        super("userEntity");
    }

    public UserEntity(Long id, String name) {
        super("userEntity");

        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
