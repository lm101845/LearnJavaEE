package com.atguigu.log.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liming
 * @Date 2023/9/25 0:52
 **/
@Slf4j
@RestController
public class HelloController {
    //Logger logger = LoggerFactory.getLogger(getClass());
    //使用@slf4j注解，这一行代码也可以不用写了
    @GetMapping("/h")
    public String hello(String a,String b){
        for (int i = 0; i < 100; i++) {
            log.trace("trace 日志...");
            log.debug("debug 日志...");
            log.info("info 日志...参数a：${} 参数b:{}",a,b);
            //info是默认日志级别
            //注意：trace和debug的打印会有安全问题！！！！！
            log.warn("warn 日志...");
            log.error("error 日志...");
            //log.info("哈哈哈，方法进来了,使用slf4j注解");
            //logger.info("哈哈哈，方法进来了");
        }
        log.trace("trace 日志...");
        log.debug("debug 日志...");
        log.info("info 日志...参数a：${} 参数b:{}",a,b);
        //info是默认日志级别
        //注意：trace和debug的打印会有安全问题！！！！！
        log.warn("warn 日志...");
        log.error("error 日志...");
        //log.info("哈哈哈，方法进来了,使用slf4j注解");
        //logger.info("哈哈哈，方法进来了");
        return "hello";
    }
}
