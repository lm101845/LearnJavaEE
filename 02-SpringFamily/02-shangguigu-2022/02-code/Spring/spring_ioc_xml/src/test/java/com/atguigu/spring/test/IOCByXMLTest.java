package com.atguigu.spring.test;

import com.atguigu.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author liming
 * @Date 2022/12/24 23:14
 **/
public class IOCByXMLTest {
    @Test
    public void testIOC(){
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean
        Student studentOne = (Student) ioc.getBean("studentOne");
        System.out.println(studentOne);
    }
}
