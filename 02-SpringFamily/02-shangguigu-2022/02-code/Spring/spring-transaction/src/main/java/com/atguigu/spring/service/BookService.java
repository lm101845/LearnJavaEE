package com.atguigu.spring.service;

/**
 * @Author liming
 * @Date 2023/1/8 13:20
 **/
public interface BookService {
    /**
     * 买书
     * @param userId
     * @param bookId
     */
    void buyBook(Integer userId, Integer bookId);
}
