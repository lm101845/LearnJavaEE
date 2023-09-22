package com.atguigu.spring6.xmltx.service;

/**
 * @Author liming
 * @Date 2023/9/21 17:05
 **/
public interface BookService {
    //买书的方法：用户id和图书id
    void buyBook(Integer bookId, Integer userId);
}
