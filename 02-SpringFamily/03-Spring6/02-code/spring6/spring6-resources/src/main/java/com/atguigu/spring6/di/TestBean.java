package com.atguigu.spring6.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author liming
 * @Date 2023/9/22 16:46
 **/
public class TestBean {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-resource.xml");
        ResourceBean resourceBean = context.getBean(ResourceBean.class);
        resourceBean.parse();
    }
}
