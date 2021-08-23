package com.example.service;

import com.example.entity.User;

public interface UserService {
    void add(User user);
    User queryOne(String username);
}
