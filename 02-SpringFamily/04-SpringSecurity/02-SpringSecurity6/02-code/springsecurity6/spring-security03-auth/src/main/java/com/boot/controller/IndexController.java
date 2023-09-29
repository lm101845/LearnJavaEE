package com.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/user/api")
    public String user() {
        return "user";
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
