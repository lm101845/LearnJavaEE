package com.itheima;

import com.itheima.service.BookService;
import com.itheima.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author liming
 * @Date 2022/11/14 13:05
 **/
public class AppForName {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService)ctx.getBean("service2");
        //service service2 bookEbi随便哪个都行
        bookService.save();
    }
}
