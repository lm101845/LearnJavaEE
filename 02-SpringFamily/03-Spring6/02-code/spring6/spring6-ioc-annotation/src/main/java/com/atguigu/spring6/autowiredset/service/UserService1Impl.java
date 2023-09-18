package com.atguigu.spring6.autowiredset.service;

import com.atguigu.spring6.autowiredset.dao.UserDao1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author liming
 * @Date 2023/9/18 17:58
 **/
@Service
public class UserService1Impl implements UserService1 {

    //service里面注入dao
    private UserDao1 userDao1;

    @Autowired
    public void setUserDao(UserDao1 userDao1) {
        this.userDao1 = userDao1;
    }

    @Override
    public void add() {
        System.out.println("service...");
        userDao1.add();
    }
}
