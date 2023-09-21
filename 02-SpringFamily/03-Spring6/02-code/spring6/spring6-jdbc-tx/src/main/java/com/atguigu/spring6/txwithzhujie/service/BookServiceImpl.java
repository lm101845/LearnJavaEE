package com.atguigu.spring6.txwithzhujie.service;

import com.atguigu.spring6.txwithzhujie.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @Author liming
 * @Date 2023/9/21 17:06
 **/

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    //买书的方法：用户id和图书id
    @Override
    //@Transactional
    //@Transactional(readOnly = true)  //只读
    //@Transactional(timeout = 3)  //3秒还没响应就超时
    //@Transactional(noRollbackFor = ArithmeticException.class)  //出现ArithmeticException异常(如1/0)不会滚
    //@Transactional(isolation = Isolation.DEFAULT)
    //@Transactional(propagation = Propagation.REQUIRED)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void buyBook(Integer bookId, Integer userId) {
        //模拟超时效果
        //try {
        //    TimeUnit.SECONDS.sleep(5);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}

        //根据图书id查询图书价格
        Integer price = bookDao.getBookPriceByBookId(bookId);
        //更新图书表库存量 -1
        bookDao.updateStock(bookId);
        //更新用户表用户余额-图书价格
        bookDao.updateUserBalance(userId,price);

        //手动写一个异常,并且让前面的操作不回滚
        //System.out.println(1 / 0);
    }
}
