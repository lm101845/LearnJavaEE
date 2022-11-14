package com.itheima.dao.impl;

import com.itheima.dao.BookDao;

/**
 * @Author liming
 * @Date 2022/11/14 12:59
 **/
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("book dao save ...");
    }
}
