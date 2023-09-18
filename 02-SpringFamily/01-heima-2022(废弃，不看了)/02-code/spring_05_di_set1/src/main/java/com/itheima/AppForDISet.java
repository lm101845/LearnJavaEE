package com.itheima;

import com.itheima.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author liming
 * @Date 2022/11/28 7:52
 **/
public class AppForDISet {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService)ctx.getBean("bookService");
        //getBean是用来获取applicationContext.xml文件里bean的，（）写的是bean的id。
        System.out.println(bookService);
        bookService.save();
    }
}
