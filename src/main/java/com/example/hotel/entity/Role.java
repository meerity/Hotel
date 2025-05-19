package com.example.hotel.entity;

import jakarta.persistence.*;

@Entity
public class Role {
    @Id
    @GeneratedValue
    Long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private ERole name;

    public enum ERole {
        ROLE_USER, ROLE_ADMIN
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}
