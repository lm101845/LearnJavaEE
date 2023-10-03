package com.atguigu.boot3.core.service;

import com.atguigu.boot3.core.entity.UserEntity;
import com.atguigu.boot3.core.event.LoginSuccessEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @Author liming
 * @Date 2023/10/3 9:25
 **/

//写法3：连实现接口都不需要了
@Service
public class AccountService3{

    @EventListener
    //@EventListener有顺序(按事件字母执行)
    //也可以使用@Order注解(数字越小优先级越高)
    @Order(1)
    public void onEvent(LoginSuccessEvent loginSuccessEvent){
        System.out.println("AccountService3更简单方法也能感知到事件=============");
        UserEntity source = (UserEntity)loginSuccessEvent.getSource();
        addAccountScore(source.getUsername());
    }

    public void addAccountScore(String username){
        System.out.println(username + "加了一分积分");
    }

}
