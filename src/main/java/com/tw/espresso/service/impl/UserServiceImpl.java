package com.tw.espresso.service.impl;

import com.tw.espresso.dao.UserDao;
import com.tw.espresso.model.User;
import com.tw.espresso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }
}
