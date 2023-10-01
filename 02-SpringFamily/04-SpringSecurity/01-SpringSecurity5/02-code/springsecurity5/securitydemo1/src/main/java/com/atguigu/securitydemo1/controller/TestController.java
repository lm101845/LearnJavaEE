package com.atguigu.securitydemo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liming
 * @Date 2023/9/30 15:10
 **/

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("hello")
    public String add(){
        return "hello security";
    }
}
