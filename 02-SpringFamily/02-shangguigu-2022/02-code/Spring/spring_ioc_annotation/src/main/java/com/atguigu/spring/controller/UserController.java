package com.atguigu.spring.controller;

import com.atguigu.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @Author liming
 * @Date 2023/1/1 15:49
 **/
@Controller("controller")
//@Controller
public class UserController {
    //三种方式都行，推荐使用第1种
    @Autowired
    //@Autowired(required = false )
    //@Qualifier("userServiceImpl")
    private UserService userService;

    //@Autowired
    //public UserController(UserService userService) {
    //    this.userService = userService;
    //}

    //@Autowired
    //public void setUserService(UserService userService) {
    //    this.userService = userService;
    //}

    public void saveUser(){
        userService.saveUser();
    }
}
