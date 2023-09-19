package com.atguigu.spring6.autowiredconstructor.dao;

import org.springframework.stereotype.Repository;

/**
 * @Author liming
 * @Date 2023/9/19 20:55
 **/

@Repository
public class UserRedisDaoImpl implements UserDao2{
    @Override
    public void add() {
        System.out.println("UserRedisDaoImpl也实现了UserDao2这个接口");
    }
}
