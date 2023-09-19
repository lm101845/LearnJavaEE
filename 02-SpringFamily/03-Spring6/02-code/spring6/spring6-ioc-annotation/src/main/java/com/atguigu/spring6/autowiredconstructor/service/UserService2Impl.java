package com.atguigu.spring6.autowiredconstructor.service;

import com.atguigu.spring6.autowiredconstructor.dao.UserDao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @Author liming
 * @Date 2023/9/18 17:58
 **/
@Service
public class UserService2Impl implements UserService2 {

    //service里面注入dao
    //private UserDao2 userDao2;

    //第三种方式：构造方法注入
    //@Autowired
    //public UserService2Impl(UserDao2 userDao2) {
    //    this.userDao2 = userDao2;
    //}

    //第四种方式：形参上注入(这个我就不单独新建一个包了，太麻烦了)
    //public UserService2Impl(@Autowired UserDao2 userDao2) {
    //    this.userDao2 = userDao2;
    //}

    //第五种方式：使用两个注解，根据名称(首字母小写)进行注入
    @Autowired
    @Qualifier(value = "userRedisDaoImpl")
    //这里是创建了两个dao实现类，也就是说有两个daobean，根据类型去注入会不知道将那个注入,所以要特别标明
    private UserDao2 userDao2;


    @Override
    public void add() {
        System.out.println("service...");
        userDao2.add();
    }
}
