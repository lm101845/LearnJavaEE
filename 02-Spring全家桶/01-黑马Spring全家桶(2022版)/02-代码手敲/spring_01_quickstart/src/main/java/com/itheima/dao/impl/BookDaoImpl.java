package com.itheima.dao.impl;

import com.itheima.dao.BookDao;

/**
 * @Author liming
 * @Date 2022/9/23 18:17
 **/
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("book dao save ...");
    }
}
