package com.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author liming
 * @Date 2023/9/28 15:48
 **/
@Controller
public class IndexController {
    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
