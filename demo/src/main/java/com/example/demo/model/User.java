package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "username",nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;

    public User() {}

    public User(Long id, String userName, String password) {
        this.id = id;
        this.username = userName;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public boolean verifyPassword(User user){
        return Objects.equals(this.getPassword(), user.getPassword());
    }
}
