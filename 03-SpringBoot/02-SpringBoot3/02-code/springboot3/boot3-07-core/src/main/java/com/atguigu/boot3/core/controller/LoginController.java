package com.atguigu.boot3.core.controller;

import com.atguigu.boot3.core.service.AccountService;
import com.atguigu.boot3.core.service.CouponService;
import com.atguigu.boot3.core.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liming
 * @Date 2023/10/3 9:15
 **/
@RestController
public class LoginController {
    /**
     * 方法1.以前写法：把所有service都注入过来
     * 方法1缺点：每增加一个业务，都要在后面增加更多代码
     * 不符合设计模式中的开闭原则(对新增开放,对修改关闭)
     * 优化方法：可以利用事件机制
     */
    @Autowired
    AccountService accountService;

    @Autowired
    CouponService couponService;

    @Autowired
    SysService sysService;

    @GetMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password")String password){
        //业务处理登录
        System.out.println("业务处理登录完成...");
        //1.账户服务：自动签到加积分
        accountService.addAccountScore(username);
        //2.优惠服务：随机发放优惠券
        couponService.sendCoupon(username);
        //3.系统服务：登记用户登录信息
        sysService.recordLog(username);

        return username + "登录成功";
    }
}
