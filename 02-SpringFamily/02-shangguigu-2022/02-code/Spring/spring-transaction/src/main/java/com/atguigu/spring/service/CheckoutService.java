package com.atguigu.spring.service;

/**
 * @Author liming
 * @Date 2023/1/8 19:06
 **/
public interface CheckoutService {
    /**
     * 结账
     * @param userId
     * @param bookIds
     */
    void checkout(Integer userId, Integer[] bookIds);
}
