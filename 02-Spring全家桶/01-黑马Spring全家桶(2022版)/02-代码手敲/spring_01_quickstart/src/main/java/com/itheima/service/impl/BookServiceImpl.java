package com.itheima.service.impl;

import com.itheima.dao.BookDao;
//import com.itheima.dao.impl.BookDaoImpl;
import com.itheima.service.BookService;

/**
 * @Author liming
 * @Date 2022/9/23 18:20
 **/
public class BookServiceImpl implements BookService {
    //5.删除业务层中使用new的方式创建的dao对象
//    private BookDao bookDao= new BookDaoImpl();
    private BookDao bookDao;
    @Override
    public void save(){
        System.out.println("book service save ...");
        bookDao.save();
    }

    //6.提供对应的set方法(容器来执行的)
    public void setBookDao(BookDao bookDao){
        this.bookDao = bookDao;
    }
}
