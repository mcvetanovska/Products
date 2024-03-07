package com.example.products.model;

import jakarta.persistence.*;

@Entity
@Table( name = "shop_user")
public class User {

    public User() {
    }

    public User(String username, String password, com.example.products.model.Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Id
    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private com.example.products.model.Role role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public com.example.products.model.Role getRole() {
        return role;
    }

    public void setRole(com.example.products.model.Role role) {
        this.role = role;
    }
}
