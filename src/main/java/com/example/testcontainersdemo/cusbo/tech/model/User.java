package com.example.testcontainersdemo.cusbo.tech.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "messenger_user")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer status;

    private String name;

    public User(String sample, String name, int status) {
        this.name = name;
        this.status = status;
    }
}
