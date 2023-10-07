package com.atguigu.boot3.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author liming
 * @Date 2023/10/7 22:14
 **/
@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage(){

        return "login";
    }
}
