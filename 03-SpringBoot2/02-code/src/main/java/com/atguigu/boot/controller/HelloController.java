package com.atguigu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liming
 * @Date 2023/2/4 19:07
 **/
//@ResponseBody
//@Controller
@RestController
//@RestController = @Controller + @ResponseBody
public class HelloController {
    @RequestMapping("/hello")
    public String handle01(){
        return "Hello,Spring Boot 2";
    }
}
