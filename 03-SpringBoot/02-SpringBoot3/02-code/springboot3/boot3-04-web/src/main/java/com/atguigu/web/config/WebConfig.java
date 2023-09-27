package com.atguigu.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author liming
 * @Date 2023/9/27 18:12
 **/

//全面接管springmvc
@Configuration
//禁用Mvc的功能
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
}
