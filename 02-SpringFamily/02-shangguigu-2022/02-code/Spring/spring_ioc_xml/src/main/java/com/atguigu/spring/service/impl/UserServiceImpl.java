package com.atguigu.spring.service.impl;

import com.atguigu.spring.dao.UserDao;
import com.atguigu.spring.service.UserService;

/**
 * @Author liming
 * @Date 2022/12/29 22:00
 **/
public class UserServiceImpl implements UserService {
    /**
     * 我们把这些类交给IOC容器管理之后，我们要想把这些属性赋值，我们有2种方式：
     *  1.set注入
     *  2.构造器注入
     */
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
