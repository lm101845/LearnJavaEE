package com.atguigu.spring6.tx.controller;

import com.atguigu.spring6.tx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author liming
 * @Date 2023/9/21 17:05
 **/

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    //哪个用户买哪一本书
    //买书的方法：用户id和图书id
    public void buyBook(Integer bookId,Integer userId){
        //调用service方法
        bookService.buyBook(bookId,userId);
    }
}
