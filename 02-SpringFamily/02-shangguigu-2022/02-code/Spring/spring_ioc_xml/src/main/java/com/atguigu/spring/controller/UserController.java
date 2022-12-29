package com.atguigu.spring.controller;

import com.atguigu.spring.service.UserService;
import com.atguigu.spring.service.impl.UserServiceImpl;

/**
 * @Author liming
 * @Date 2022/12/29 21:53
 **/
public class UserController {
    //private UserService userService = new UserServiceImpl();
    //硬编码，写死了

    private UserService userService;
    //我们这里说的是实现类，不是接口，因为接口你是不能交给bean标签管理的

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void saveUser(){
        userService.saveUser();
    }
}
