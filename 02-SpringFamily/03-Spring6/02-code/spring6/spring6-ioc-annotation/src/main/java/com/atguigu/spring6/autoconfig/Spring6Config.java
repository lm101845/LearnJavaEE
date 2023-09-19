package com.atguigu.spring6.autoconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author liming
 * @Date 2023/9/19 21:32
 **/

@Configuration   //配置类
@ComponentScan("com.atguigu.spring6")
//springboot中，这个注解直接写在启动类上，而不是配置类上
public class Spring6Config {

}
