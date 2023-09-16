package com.atguigu.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


//主程序：com.atguigu.boot(SpringBoot只会扫描主程序所在的包及其下面的子包，自动的component-scan功能)
//@SpringBootApplication
//扫描规则方法1：
@SpringBootApplication(scanBasePackages = "com.atguigu")
//扫描规则方法2：直接指定扫描路径
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan("com.atguigu")
public class MainApplication {

    public static void main(String[] args) {
        //SpringApplication.run(Boot302DemoApplication.class, args);

        //java10： 局部变量类型的自动推断
        var ioc = SpringApplication.run(MainApplication.class, args);

        //1、获取容器中所有组件的名字
        String[] names = ioc.getBeanDefinitionNames();
        //2、挨个遍历：
        // dispatcherServlet、beanNameViewResolver、characterEncodingFilter、multipartResolver
        // SpringBoot把以前配置的核心组件现在都给我们自动配置好了。
        for (String name : names) {
            System.out.println(name);
        }
    }

}
