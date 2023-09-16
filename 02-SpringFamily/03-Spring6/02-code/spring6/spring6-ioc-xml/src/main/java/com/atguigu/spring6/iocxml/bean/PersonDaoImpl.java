package com.atguigu.spring6.iocxml.bean;

/**
 * @Author liming
 * @Date 2023/9/16 22:40
 **/
public class PersonDaoImpl implements UserDao{
    @Override
    public void run() {
        System.out.println("PersonDaoImpl另一个实现类的方法执行了...");
    }
}
