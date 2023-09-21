package com.atguigu.dao.impl;

import com.atguigu.annotation.Bean;
import com.atguigu.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @Author liming
 * @Date 2023/9/19 23:31
 **/

//@Repository
//用我们自己的注解：
@Bean
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("dao......");
    }
}
