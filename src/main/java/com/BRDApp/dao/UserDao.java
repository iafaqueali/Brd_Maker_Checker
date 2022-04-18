package com.BRDApp.dao;

import com.BRDApp.entity.User;

public interface UserDao {
    void save(User user);
    User getUser(String username);
     Boolean loginUser(User user);
}
