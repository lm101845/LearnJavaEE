package com.atguigu.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liming
 * @Date 2023/2/8 21:56
 **/

@RestController
public class WorldController {
    @RequestMapping("/w")
    public String world666(){
        return "world111-只有放在同级目录下才生效";
    }
}
