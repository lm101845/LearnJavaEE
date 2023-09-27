package com.atguigu.web.config;

import com.atguigu.web.component.MyYamlHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @Author liming
 * @Date 2023/9/26 21:49
 **/
//@Configuration
//public class MyConfig3 {
//    //配置一个能把对象转为yaml的MessageConverter
//    @Bean
//    public WebMvcConfigurer webMvcConfigurer(){
//        return new WebMvcConfigurer() {
//            @Override //配置一个能把对象转为yaml的messageConverter
//            public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//                converters.add(new MyYamlHttpMessageConverter());
//            }
//        };
//    }
//}
