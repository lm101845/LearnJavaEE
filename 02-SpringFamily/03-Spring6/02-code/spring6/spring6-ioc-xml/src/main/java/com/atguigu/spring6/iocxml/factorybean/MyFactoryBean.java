package com.atguigu.spring6.iocxml.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Author liming
 * @Date 2023/9/18 16:12
 **/
public class MyFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
