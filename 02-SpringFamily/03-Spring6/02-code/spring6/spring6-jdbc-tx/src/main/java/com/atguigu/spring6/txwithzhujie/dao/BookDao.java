package com.atguigu.spring6.txwithzhujie.dao;

/**
 * @Author liming
 * @Date 2023/9/21 17:06
 **/
public interface BookDao {
    Integer getBookPriceByBookId(Integer bookId);

    void updateStock(Integer bookId);

    void updateUserBalance(Integer userId, Integer price);
}
