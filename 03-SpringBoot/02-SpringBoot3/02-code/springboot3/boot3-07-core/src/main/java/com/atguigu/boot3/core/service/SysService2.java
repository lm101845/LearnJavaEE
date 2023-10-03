package com.atguigu.boot3.core.service;

import com.atguigu.boot3.core.entity.UserEntity;
import com.atguigu.boot3.core.event.LoginSuccessEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * @Author liming
 * @Date 2023/10/3 9:28
 **/

@Service
public class SysService2 implements ApplicationListener<LoginSuccessEvent> {
    public void recordLog(String username){
        System.out.println(username + "登录信息已被记录");
    }

    @Override
    public void onApplicationEvent(LoginSuccessEvent event) {
        System.out.println("SysService2收到事件==============");
        UserEntity source = (UserEntity) event.getSource();
        recordLog(source.getUsername());
    }
}
