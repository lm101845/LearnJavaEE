package com.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liming
 * @Date 2023/9/28 15:20
 **/

@RestController
public class IndexController {
    @GetMapping("/index")
    public String index(){
        return "Hello SpringSecurity";
    }
}
