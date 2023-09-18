package com.itheima.factory;

import com.itheima.dao.OrderDao;
import com.itheima.dao.impl.OrderDaoImpl;

/**
 * @Author liming
 * @Date 2022/11/14 13:45
 **/
public class OrderDaoFactory {
    public static OrderDao getOrderDao(){
        //静态方法
        System.out.println("factory setup....");
        return new OrderDaoImpl();
    }
}
