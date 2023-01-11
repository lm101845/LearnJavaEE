package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author liming
 * @Date 2023/1/11 20:35
 **/
@Controller
public class HelloController {
    @RequestMapping("/")
    public String protal(){
        //将逻辑视图返回
        return "index";
     }

     @RequestMapping("/hello")
     public String hello(){
        return "success";
     }
}
