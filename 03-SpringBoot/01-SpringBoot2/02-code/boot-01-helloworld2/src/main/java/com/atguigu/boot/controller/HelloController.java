package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liming
 * @Date 2023/2/10 11:26
 **/

@RestController
public class HelloController {
    @Autowired
    Person person;
    @RequestMapping("/person")
    public Person person(){
        return person;
    }
}
