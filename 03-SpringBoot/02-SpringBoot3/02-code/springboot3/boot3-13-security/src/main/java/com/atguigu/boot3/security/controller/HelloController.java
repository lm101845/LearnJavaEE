package com.atguigu.boot3.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liming
 * @Date 2023/10/7 22:14
 **/
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello!Spring Security";
    }



    //我试了没有world_exec1这个权限的人也能访问这个地址，也不知道为什么
    @PreAuthorize("hasAuthority('world_exec1')")
    @GetMapping("/world")
    public String world(){
        return "Hello World!!!";
    }
}
