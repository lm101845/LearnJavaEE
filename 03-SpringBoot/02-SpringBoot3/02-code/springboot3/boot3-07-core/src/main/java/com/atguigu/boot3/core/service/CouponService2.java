package com.atguigu.boot3.core.service;

import com.atguigu.boot3.core.entity.UserEntity;
import com.atguigu.boot3.core.event.LoginSuccessEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * @Author liming
 * @Date 2023/10/3 9:27
 **/

@Service
public class CouponService2 implements ApplicationListener<LoginSuccessEvent> {
    public void sendCoupon(String username){
        System.out.println(username + "随机得到了一张优惠券");
    }

    @Override
    public void onApplicationEvent(LoginSuccessEvent event) {
        System.out.println("CouponService2收到事件==============");
        UserEntity source = (UserEntity) event.getSource();
        sendCoupon(source.getUsername());
    }
}
