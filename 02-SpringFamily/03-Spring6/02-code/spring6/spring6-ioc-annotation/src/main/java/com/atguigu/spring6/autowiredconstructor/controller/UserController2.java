package com.atguigu.spring6.autowiredconstructor.controller;

import com.atguigu.spring6.autowiredconstructor.service.UserService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author liming
 * @Date 2023/9/18 17:58
 **/

@Controller
public class UserController2 implements UserService2 {
    //controller里面注入service
    private UserService2 userService2;

    //第三种方式：构造方法注入
    //没有加@Autowired注解，也可以注入，是因为这个有参构造器覆盖了默认的无参构造器，
    // @Controller注解修饰的UserController会被标识为bean，所以会调用这个构造器进行属性注入
    //@Autowired
    //public UserController2(UserService2 userService2) {
    //    this.userService2 = userService2;
    //}

    //第四种方式：形参上注入(这个我就不单独新建一个包了，太麻烦了)
    //public UserController2(@Autowired UserService2 userService2) {
    //    this.userService2 = userService2;
    //}



    //第五种方式：只有一个有参数构造函数，可以不加注解(这个我就不单独新建一个包了，太麻烦了)
    public UserController2(UserService2 userService2) {
        this.userService2 = userService2;
    }

    @Override
    public void add() {
        //System.out.println("controller...构造方法注入");
        //System.out.println("controller...形参上注入");
        System.out.println("controller...只有一个有参数构造函数，可以不加注解注入");
        userService2.add();
    }
    //注意：注入实现类是可以的，但实际开发都会注入接口
}
