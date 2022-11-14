package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.service.BookService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @Author liming
 * @Date 2022/11/14 14:29
 **/
public class BookServiceImpl implements BookService, InitializingBean, DisposableBean {
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        System.out.println("set .....");
        this.bookDao = bookDao;
    }

    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //在属性设置之后
        System.out.println("service init");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("service destory");
    }
}
