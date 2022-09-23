package com.itheima;

import com.itheima.service.BookService;
import com.itheima.service.impl.BookServiceImpl;

/**
 * @Author liming
 * @Date 2022/9/23 18:22
 **/
public class App {
    public static void main(String[] args) {
        BookService bookService = new BookServiceImpl();
        bookService.save();
    }
}
