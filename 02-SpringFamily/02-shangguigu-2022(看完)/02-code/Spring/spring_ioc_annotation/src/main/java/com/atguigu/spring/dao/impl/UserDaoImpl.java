package com.atguigu.spring.dao.impl;

import com.atguigu.spring.dao.UserDao;

/**
 * @Author liming
 * @Date 2023/1/1 15:51
 **/
public class UserDaoImpl implements UserDao {

    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}
