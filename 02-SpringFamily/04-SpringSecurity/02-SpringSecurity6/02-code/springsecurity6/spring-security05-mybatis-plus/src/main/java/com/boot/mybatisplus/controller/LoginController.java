package com.boot.mybatisplus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author liming
 * @Date 2023/9/29 18:09
 **/
@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(){
        return "login";
        //转发到登录页面
    }
}
