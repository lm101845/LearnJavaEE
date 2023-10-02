package com.boot.springsecurity.jdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author liming
 * @Date 2023/9/29 18:09
 **/
@Controller
public class IndexController {
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/admin/api")
    public String admin() {
        return "admin";
    }

    @ResponseBody
    @GetMapping("/admin/api/a")
    public String adminA() {
        return "adminA";
    }

    @GetMapping("/user/api")
    public String user() {
        return "user";
    }

    @ResponseBody
    @GetMapping("/user/api/my/center")
    public String user_center() {
        return "用户中心";
    }

    @GetMapping("/app/api")
    public String app() {
        return "app";
    }

    @GetMapping("/noAuth")
    public String noAuth() {
        return "noAuth";
    }
}
