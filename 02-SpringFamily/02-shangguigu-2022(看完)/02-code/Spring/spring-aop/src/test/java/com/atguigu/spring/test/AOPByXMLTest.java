package com.atguigu.spring.test;

import com.atguigu.spring.aop.xml.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author liming
 * @Date 2023/1/8 10:40
 **/
public class AOPByXMLTest {
    @Test
    public void testAOPByXML(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-xml.xml");
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.add(10,20);
    }
}
