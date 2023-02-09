package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String handle01(@RequestParam("name") String name){
        return "Hello,Spring Boot 2" + "你好，中文不乱码" + name;
    }

    @Autowired
    Car car;
    @RequestMapping("/car")
    public Car car(){
        return car;
    }
}
