package com.itheima.factory;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;

/**
 * @Author liming
 * @Date 2022/11/14 13:47
 **/
public class UserDaoFactory {
    public UserDao getUserDao(){
        //非静态方法
        return new UserDaoImpl();
    }
}
