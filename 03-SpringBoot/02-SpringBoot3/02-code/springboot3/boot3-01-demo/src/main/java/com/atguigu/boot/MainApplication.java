package com.atguigu.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author liming
 * @Date 2023/9/15 23:27
 * @Description 启动SpringBoot项目的主入口程序
 **/

@SpringBootApplication
//这是一个SpringBoot应用
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class,args);
    }
}
