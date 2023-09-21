package com.atguigu.spring6.tx.service;

import com.atguigu.spring6.tx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author liming
 * @Date 2023/9/21 17:06
 **/

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookDao bookDao;

    //买书的方法：用户id和图书id
    @Override
    public void buyBook(Integer bookId, Integer userId) {
        //根据图书id查询图书价格
        Integer price = bookDao.getBookPriceByBookId(bookId);
        //更新图书表库存量 -1
        bookDao.updateStock(bookId);
        //更新用户表用户余额-图书价格
        bookDao.updateUserBalance(userId,price);
    }
}
