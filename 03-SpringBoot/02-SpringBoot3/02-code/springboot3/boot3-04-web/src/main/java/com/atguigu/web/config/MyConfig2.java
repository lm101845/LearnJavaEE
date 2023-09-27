package com.atguigu.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

/**
 * @Author liming
 * @Date 2023/9/26 10:56
 **/
//写法2：
//无论那种写法，都要放webmvcconfigurer这个组件到ioc容器中
//@Configuration //这是一个配置类,给容器中放一个 WebMvcConfigurer 组件，就能自定义底层
//public class MyConfig2 {
//    @Bean
//    public WebMvcConfigurer webMvcConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addResourceHandlers(ResourceHandlerRegistry registry) {
//                registry.addResourceHandler("/static/**")
//                        .addResourceLocations("classpath:/a/", "classpath:/b/")
//                        .setCacheControl(CacheControl.maxAge(1180, TimeUnit.SECONDS));
//            }
//        };
//    }
//
//}
