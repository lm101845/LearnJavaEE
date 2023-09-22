package com.atguigu.spring6.validator.two;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * @Author liming
 * @Date 2023/9/23 0:27
 **/

@Configuration
@ComponentScan("com.atguigu.spring6.validator.two")
public class ValidationConfig {
    @Bean
    public LocalValidatorFactoryBean validator(){
        return new LocalValidatorFactoryBean();
    }
}
