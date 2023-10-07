package com.atguigu.boot3.actuator.controller;

import com.atguigu.boot3.actuator.component.MyHahaComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liming
 * @Date 2023/10/7 23:32
 **/
@RestController
public class HelloController {

    @Autowired
    MyHahaComponent myHahaComponent;

    @GetMapping("/hello")
    public String hello(){
        //业务调用
        myHahaComponent.hello();
        return "哈哈哈";
    }
}
