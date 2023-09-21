package com.atguigu.spring6.txwithzhujie.service;

/**
 * @Author liming
 * @Date 2023/9/21 22:37
 **/
public interface CheckoutService {
    //买多本书的方法
    void checkout(Integer[] bookIds,Integer userId);
}
