package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.factory.UserDaoFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author liming
 * @Date 2022/11/14 13:56
 **/
public class AppForInstanceUser {
    public static void main(String[] args) {
        ////创建实例工厂对象
        //UserDaoFactory userDaoFactory = new UserDaoFactory();
        ////通过实例工厂对象创建对象
        //UserDao userDao = userDaoFactory.getUserDao();
        //userDao.save();

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) ctx.getBean("userDao");
        UserDao userDao2 = (UserDao) ctx.getBean("userDao");
        System.out.println(userDao1);
        System.out.println(userDao2);
        //默认是单例的，除非你把isSingleton方法返回值改成false即可
        userDao1.save();
    }
}
