package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Car;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
//日志注解，用了它，就不用在控制台System.out(xxx)了
public class HelloController {
    @RequestMapping("/hello")
    public String handle01(@RequestParam("name") String name){
        log.info("请求进来了....");
        return "Hello,Spring Boot 2" + "你好，中文不乱码" + name;
    }

    @Autowired
    Car car;
    @RequestMapping("/car")
    public Car car(){
        return car;
    }
}
