package com.atguigu.boot;

import com.atguigu.boot.bean.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author liming
 * @Date 2023/9/15 23:27
 * @Description 启动SpringBoot项目的主入口程序
 **/

@SpringBootApplication
//这是一个SpringBoot应用
public class MainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(MainApplication.class, args);

        Person person = ioc.getBean(Person.class);
        System.out.println(person);
    }
}
