package com.itheima.factory;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Author liming
 * @Date 2022/11/14 14:04
 **/
public class UserDaoFactoryBean implements FactoryBean<UserDao> {
    //代替原始实例工厂中创建对象的方法
    @Override
    public UserDao getObject() throws Exception {
        return new UserDaoImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return UserDao.class;
        //这个对象是UserDao类型，所以把UserDao的字节码放上去就可以了
    }

    //控制对象是否是单例，默认就是单例的
    @Override
    public boolean isSingleton() {
        return true;
    }
}
