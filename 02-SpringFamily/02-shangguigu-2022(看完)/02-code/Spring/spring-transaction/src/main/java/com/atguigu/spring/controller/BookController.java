package com.atguigu.spring.controller;

import com.atguigu.spring.service.BookService;
import com.atguigu.spring.service.CheckoutService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author liming
 * @Date 2023/1/8 13:20
 **/

/**
 * @component是通用性的注解，@service 和@repository则是在@component的基础上添加了特定的功能。
 * 所以@component可以替换为@service和@repository，但是为了规范，
 * 服务层bean用@service，dao层用@repository。就好比代码规范，变量、方法命名一样。
 */
@Component
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CheckoutService checkoutService;
    //买书的方法
    public void buyBook(Integer userId,Integer bookId){
        bookService.buyBook(userId,bookId);
    }

    //结账的方法(事物)
    public void checkout(Integer userId,Integer[] bookIds){
        checkoutService.checkout(userId,bookIds);
    }
}
