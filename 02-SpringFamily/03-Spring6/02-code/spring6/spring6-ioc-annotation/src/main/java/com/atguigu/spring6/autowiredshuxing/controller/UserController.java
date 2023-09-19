package com.atguigu.spring6.autowiredshuxing.controller;

import com.atguigu.spring6.autowiredshuxing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author liming
 * @Date 2023/9/18 17:58
 **/

@Controller
public class UserController implements UserService {
    //根据类型找到对应对象，完成注入
    //IDEA提示：使用变量依赖注入的方式是不被推荐的
    //第一种方式：属性注入(一般项目基本都这么写！！！，虽然IDEA不推荐这样)
    @Autowired
    //controller里面注入service
    private UserService userService;

    @Override
    public void add() {
        System.out.println("controller...");
        userService.add();
    }
    //注意：注入实现类是可以的，但实际开发都会注入接口
}
