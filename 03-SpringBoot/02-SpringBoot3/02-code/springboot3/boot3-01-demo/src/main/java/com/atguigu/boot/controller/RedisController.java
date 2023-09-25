package com.atguigu.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liming
 * @Date 2023/9/24 15:31
 **/

@RestController
public class RedisController {
    @Autowired
    StringRedisTemplate redisTemplate;

    @GetMapping("/incr")
    public String incr(){
        Long haha = redisTemplate.opsForValue().increment("haha");
        return "增加后的值" + haha;
    }
}
