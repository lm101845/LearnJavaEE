package com.atguigu.controller;

import com.atguigu.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author liming
 * @Date 2023/1/21 10:59
 **/
@Controller
public class HelloController {
    @Autowired
    private HelloService helloService;
}
