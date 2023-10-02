package com.atguigu.boot3.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Boot307CoreApplication {

    public static void main(String[] args) {
        //写法1：
        //SpringApplication.run(Boot307CoreApplication.class, args);

        //写法2：
        SpringApplication application = new SpringApplication(Boot307CoreApplication.class);
        //参数设置
        //application.addInitializers();
        application.run(args);
    }

}
