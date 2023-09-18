package com.atguigu.spring6.autowiredset.controller;

import com.atguigu.spring6.autowiredset.service.UserService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author liming
 * @Date 2023/9/18 17:58
 **/

@Controller
public class UserController1 implements UserService1 {
    //controller里面注入service
    private UserService1 userService1;

    //第二种方式：set注入(IDEA里面推荐这种做法)
    //生成set方法
    @Autowired
    public void setUserService(UserService1 userService1) {
        this.userService1 = userService1;
    }

    @Override
    public void add() {
        System.out.println("controller...set方法注入");
        userService1.add();
    }
    //注意：注入实现类是可以的，但实际开发都会注入接口
}
