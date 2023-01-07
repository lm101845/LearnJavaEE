package com.atguigu.spring.test;

import com.atguigu.spring.aop.annotaiton.Calculator;
import com.atguigu.spring.aop.annotaiton.CalculatorImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author liming
 * @Date 2023/1/7 21:31
 **/
public class AOPTest {
    @Test
    public void testAOPByAnnotation(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-annotation.xml");
        //CalculatorImpl calculator = ioc.getBean(CalculatorImpl.class);
        //calculator.add(1,2);
        Calculator calculator = ioc.getBean(Calculator.class);
        //calculator.add(1,2);
        //calculator.div(1,0);
        calculator.div(10,2);
    }
}
