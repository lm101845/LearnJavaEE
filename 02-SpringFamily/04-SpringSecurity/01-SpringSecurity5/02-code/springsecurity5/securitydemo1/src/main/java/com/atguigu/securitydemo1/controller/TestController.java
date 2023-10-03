package com.atguigu.securitydemo1.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liming
 * @Date 2023/9/30 15:10
 **/

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("hello")
    public String add(){
        return "hello security";
    }

    @GetMapping("index")
    public String index(){
        return "hello index";
    }


    @GetMapping("update")
    @Secured({"ROLE_sale","ROLE_manager"})
    //用户只有具有上面的角色才能访问
    public String update(){
        return "hello update";
    }

    @GetMapping("fix")
    @PreAuthorize("hasAnyAuthority('admins')")
    public String fix(){
        return "hello fix";
    }

    @GetMapping("happy")
    @PostAuthorize("hasAnyAuthority('admins')")
    public String happy(){
        System.out.println("happy......");
        return "hello happy";
    }

}
