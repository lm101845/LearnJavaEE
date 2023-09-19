package com.atguigu.spring6.resource.controller;

import com.atguigu.spring6.resource.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author liming
 * @Date 2023/9/18 17:58
 **/

@Controller("myUserController")
//改一下名字，不然报名字重复了

public class UserController{

    //1.根据名称进行注入
    //@Resource(name = "myUserService")
    //private UserService userService;

    //2.根据类型进行匹配
    @Resource
    private UserService userService;

    public void add() {
        System.out.println("controller...");
        userService.add();
    }
}
