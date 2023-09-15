package com.atguigu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liming
 * @Date 2023/9/15 23:33
 **/

//@Controller
//@ResponseBody
//作用于所有方法
@RestController
public class HelloController {
    @GetMapping("/hello")
    //@ResponseBody   //只作用于当前方法
    public String hello(){
        return "Hello Spring Boot3";
    }
}
