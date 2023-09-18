package com.atguigu.spring.aop.xml;

import org.springframework.stereotype.Component;

/**
 * @Author liming
 * @Date 2023/1/8 10:25
 **/
@Component
public class ValidateAspect {
    public void beforeMethod(){
        System.out.println("ValidateAspect-->前置通知");
    }
}
