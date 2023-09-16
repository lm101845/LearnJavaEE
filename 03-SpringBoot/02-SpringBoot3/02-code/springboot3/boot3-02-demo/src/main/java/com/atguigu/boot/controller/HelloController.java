package com.atguigu.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liming
 * @Date 2023/9/17 1:01
 **/
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "你好啊，自动创建的";
    }
}
