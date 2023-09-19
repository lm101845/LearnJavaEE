package com.atguigu.service.impl;

import com.atguigu.annotation.Bean;
import com.atguigu.annotation.Di;
import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author liming
 * @Date 2023/9/19 23:30
 **/

//@Service
//用我们自己的注解：
@Bean
public class UserServiceImpl implements UserService {
    //@Autowired
    //用我们自己的注解：
    @Di
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("service...");
        //调用dao里面的方法
        //userDao.add();
    }
}
