package com.atguigu.boot3.core.service;

import com.atguigu.boot3.core.entity.UserEntity;
import com.atguigu.boot3.core.event.LoginSuccessEvent;
import org.apache.catalina.User;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * @Author liming
 * @Date 2023/10/3 9:25
 **/

//写法2：
@Service
public class AccountService2 implements ApplicationListener<LoginSuccessEvent> {
    public void addAccountScore(String username){
        System.out.println(username + "加了一分积分");
    }

    @Override
    public void onApplicationEvent(LoginSuccessEvent event) {
        System.out.println("AccountService2收到事件==============");
        UserEntity source = (UserEntity) event.getSource();
        addAccountScore(source.getUsername());
    }
}
