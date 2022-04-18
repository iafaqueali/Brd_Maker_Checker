package com.BRDApp.service;

import com.BRDApp.entity.User;

public interface UserService {
    void save(User user);
    User getUser(String username);
    Boolean loginUser(User user);
}
