package com.atguigu.spring6.iocxml.auto.service;

import com.atguigu.spring6.iocxml.auto.dao.UserDao;
import com.atguigu.spring6.iocxml.auto.dao.UserDaoImpl;

/**
 * @Author liming
 * @Date 2023/9/18 16:23
 **/
public class UserServiceImpl implements UserService{
    //spring写法：
    private UserDao userDao;

    //只需要生成set方法即可
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUserService() {
        System.out.println("addUserService方法执行了");
        //原始写法：
        //service里面调用dao
        //UserDao userDao = new UserDaoImpl();
        //userDao.addUserDao();

        //sping写法：
        userDao.addUserDao();
    }
}
