package com.atguigu.spring.service.impl;

import com.atguigu.spring.dao.BookDao;
import com.atguigu.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @Author liming
 * @Date 2023/1/8 13:20
 **/
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    //@Transactional(
    //        //readOnly = true,
    //        //只有当前事物都是查询操作时，才能使用只读，这里使用只读会报错
    //        //timeout = 3,
    //        //noRollbackFor = ArithmeticException.class,
    //        //rollbackForClassName = "java.lang.ArithmeticException",
    //        //isolation = Isolation.DEFAULT
    //        propagation = Propagation.REQUIRES_NEW
    //)
    public void buyBook(Integer userId, Integer bookId) {
        //1.查询图书的价格
        Integer price = bookDao.getPriceByBookId(bookId);
        //2.更新图书的库存
        bookDao.updateStock(bookId);
        //3.更新用户的余额
        bookDao.updateBalance(userId, price);
        //System.out.println(1 / 0);
    }
}
