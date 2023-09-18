package com.atguigu.spring6.iocxml.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Author liming
 * @Date 2023/9/18 16:04
 **/
public class MyBeanPost implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("3:bean后置处理器，初始化之前执行");
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("3:bean后置处理器，初始化之后执行");
        return bean;
    }
}
