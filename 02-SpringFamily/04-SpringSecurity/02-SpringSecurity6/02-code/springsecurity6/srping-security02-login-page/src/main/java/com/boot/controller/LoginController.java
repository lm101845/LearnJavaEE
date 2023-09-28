package com.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author liming
 * @Date 2023/9/28 15:43
 **/
@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(){
        return "login";
        //转发到登录页面
    }
}
