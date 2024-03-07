package com.example.products.service;

import com.example.products.model.Role;
import com.example.products.model.User;

public interface UserService {

    /**
     * (5 points) This method should create a new user. The password should be encrypted before saving.
     *
     * @param username
     * @param password
     * @param role
     * @return
     */
    User create(String username, String password, Role role);

}
