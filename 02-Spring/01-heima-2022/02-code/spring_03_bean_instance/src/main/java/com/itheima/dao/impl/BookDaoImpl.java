package com.itheima.dao.impl;

import com.itheima.dao.BookDao;

/**
 * @Author liming
 * @Date 2022/11/14 12:59
 **/
public class BookDaoImpl implements BookDao {
    //public BookDaoImpl() {
    private BookDaoImpl() {   //以前把构造方法私有化之后，是造不出对象的，但是这里是可以的——用的是反射
    //public BookDaoImpl(int i) {   //不行，Spring调用bean的时候，用的是无参的构造方法，不能有参数
        System.out.println("book dao constructor is running ....");
    }

    @Override
    public void save() {
        System.out.println("book dao save ...");
    }
}
