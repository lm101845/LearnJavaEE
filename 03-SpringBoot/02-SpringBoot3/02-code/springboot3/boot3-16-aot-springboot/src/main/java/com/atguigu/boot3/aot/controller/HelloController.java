package com.atguigu.boot3.aot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liming
 * @Date 2023/10/9 15:26
 **/
@RestController
public class HelloController {
    @GetMapping("/")
    public String hello(){
        return "hello , Spring boot aot";
    }
}
