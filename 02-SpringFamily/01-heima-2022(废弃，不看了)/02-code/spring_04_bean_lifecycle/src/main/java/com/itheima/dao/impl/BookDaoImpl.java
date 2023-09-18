package com.itheima.dao.impl;

import com.itheima.dao.BookDao;

/**
 * @Author liming
 * @Date 2022/11/14 12:59
 **/
public class BookDaoImpl implements BookDao {

    @Override
    public void save() {
        System.out.println("book dao save");
    }

    //表示bean初始化对应的操作(init方法名是我们自己写的，它是不认识的)
    public void init(){
        System.out.println("init...");
    }

    //表示bean销毁前对应的操作
    public void destory(){
        System.out.println("destory...");
    }
}
