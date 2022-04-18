package com.BRDApp.service;

import com.BRDApp.dao.UserDao;
import com.BRDApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao dao;

    public UserDao getDao() {
        return dao;
    }

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public void save(User user) {
        dao.save(user);
    }

    @Override
    @Transactional
    public User getUser(String username) {
        return dao.getUser(username);
    }

    @Override
    @Transactional
    public Boolean loginUser(User user) {
        return dao.loginUser(user);
    }
}
