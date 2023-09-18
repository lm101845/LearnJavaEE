package com.atguigu.spring6.autowiredset.dao;

import org.springframework.stereotype.Repository;

/**
 * @Author liming
 * @Date 2023/9/18 17:59
 **/
@Repository
public class UserDao1Impl implements UserDao1 {
    @Override
    public void add() {
        System.out.println("dao...");
    }
}
