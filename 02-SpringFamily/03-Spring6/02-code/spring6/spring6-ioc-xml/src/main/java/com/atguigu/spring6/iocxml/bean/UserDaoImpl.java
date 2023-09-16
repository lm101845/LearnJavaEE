package com.atguigu.spring6.iocxml.bean;

/**
 * @Author liming
 * @Date 2023/9/16 22:30
 **/
public class UserDaoImpl implements UserDao{
    @Override
    public void run() {
        System.out.println("run....");
    }
}
