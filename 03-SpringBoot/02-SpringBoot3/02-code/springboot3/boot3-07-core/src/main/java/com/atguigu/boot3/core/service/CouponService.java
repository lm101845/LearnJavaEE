package com.atguigu.boot3.core.service;

import org.springframework.stereotype.Service;

/**
 * @Author liming
 * @Date 2023/10/3 9:27
 **/

@Service
public class CouponService {
    public void sendCoupon(String username){
        System.out.println(username + "随机得到了一张优惠券");
    }
}
