package com.atguigu.spring6.autowiredshuxing.dao;

import org.springframework.stereotype.Repository;

/**
 * @Author liming
 * @Date 2023/9/18 17:59
 **/
@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public void add() {
        System.out.println("dao...");
    }
}
