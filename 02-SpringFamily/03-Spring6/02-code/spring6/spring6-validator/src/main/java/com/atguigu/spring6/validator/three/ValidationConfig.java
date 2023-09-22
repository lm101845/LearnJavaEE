package com.atguigu.spring6.validator.three;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * @Author liming
 * @Date 2023/9/23 0:44
 **/
@Configuration
@ComponentScan("com.atguigu.spring6.validator.three")
public class ValidationConfig {
    @Bean
    public MethodValidationPostProcessor validationPostProcessor(){
        return new MethodValidationPostProcessor();
    }
}
