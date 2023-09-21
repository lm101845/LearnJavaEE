package com.atguigu.spring6.txwithzhujie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author liming
 * @Date 2023/9/21 22:38
 **/

@Service
public class CheckoutServiceImpl implements CheckoutService{
    //注入bookService
    @Autowired
    private BookService bookService;

    @Transactional
    @Override
    public void checkout(Integer[] bookIds, Integer userId) {
        for(Integer bookId:bookIds){
            //调用service的方法
            bookService.buyBook(bookId,userId);
        }
    }
}
