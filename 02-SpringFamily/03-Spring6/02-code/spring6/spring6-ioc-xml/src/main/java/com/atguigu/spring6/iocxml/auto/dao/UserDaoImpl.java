package com.atguigu.spring6.iocxml.auto.dao;

/**
 * @Author liming
 * @Date 2023/9/18 16:24
 **/
public class UserDaoImpl implements UserDao{

    @Override
    public void addUserDao() {
        System.out.println("UserDao里面的方法执行了");
    }
}
