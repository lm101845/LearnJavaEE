package com.atguigu.spring6.autowiredshuxing.service;

import com.atguigu.spring6.autowiredshuxing.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author liming
 * @Date 2023/9/18 17:58
 **/
@Service
public class UserServiceImpl implements UserService{
    //第一种方式：属性注入
    @Autowired
    //service里面注入dao
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("service...");
        userDao.add();
    }
}
