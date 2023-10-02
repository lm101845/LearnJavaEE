package com.atguigu.boot3.features.config;

import com.atguigu.boot3.features.bean.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author liming
 * @Date 2023/10/2 10:08
 **/

@PropertySource("classpath:apple.properties")
@Profile("test")  //只有指定环境被激活整个类的所有配置才能生效
public class MyConfig {
    @Profile("dev")
    @Bean
    public Cat cat(){
        return new Cat();
    }
}
