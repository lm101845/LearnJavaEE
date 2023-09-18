package com.atguigu.spring6.autowiredconstructor.dao;

import org.springframework.stereotype.Repository;

/**
 * @Author liming
 * @Date 2023/9/18 17:59
 **/
@Repository
public class UserDao2Impl implements UserDao2 {
    @Override
    public void add() {
        System.out.println("dao...");
    }
}
