package com.atguigu.spring6.iocxml.auto.controller;

import com.atguigu.spring6.iocxml.auto.service.UserService;
import com.atguigu.spring6.iocxml.auto.service.UserServiceImpl;

/**
 * @Author liming
 * @Date 2023/9/18 16:21
 **/
public class UserController {
    //spring写法：
    private UserService userService;

    //只需要生成set方法即可
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void addUser(){
        System.out.println("controller方法执行了");
        //原始写法：
        //controller里面调用service
        //UserService userService = new UserServiceImpl();
        //userService.addUserService();

        //spring写法：
        //调用service中的方法
        userService.addUserService();
        //三个方法都执行了！！
        //controller方法执行了
        //addUserService方法执行了
        //UserDao里面的方法执行了
    }
}
