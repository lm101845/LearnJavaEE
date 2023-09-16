package com.atguigu;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liming
 * @Date 2023/9/17 1:01
 **/
@RestController
//正常情况下，写在这里是不会被扫描到的
public class HelloController2 {
    @GetMapping("/saomiao")
    public String hello(){
        return "正常情况下，写在这里是不会被扫描到的";
    }
}
