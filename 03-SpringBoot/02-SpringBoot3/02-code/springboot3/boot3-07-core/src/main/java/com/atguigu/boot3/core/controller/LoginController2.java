package com.atguigu.boot3.core.controller;

import com.atguigu.boot3.core.entity.UserEntity;
import com.atguigu.boot3.core.event.EventPublish;
import com.atguigu.boot3.core.event.LoginSuccessEvent;
import com.atguigu.boot3.core.service.AccountService;
import com.atguigu.boot3.core.service.CouponService;
import com.atguigu.boot3.core.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liming
 * @Date 2023/10/3 9:15
 **/
@RestController
public class LoginController2 {
    /**
     * 方法2：优化写法之事件驱动开发
     */
    @Autowired
    AccountService accountService;

    @Autowired
    CouponService couponService;

    @Autowired
    SysService sysService;

    @Autowired
    EventPublish eventPublish;

    @GetMapping("/login2")
    public String login(@RequestParam("username") String username, @RequestParam("password")String password){
        //业务处理登录
        System.out.println("业务处理登录完成...");

        //发送事件
        //1.创建事件信息
        LoginSuccessEvent loginSuccessEvent = new LoginSuccessEvent(new UserEntity(username,password));
        //2.发送事件
        eventPublish.sendEvent(loginSuccessEvent);

        return username + "登录成功";
    }
}
