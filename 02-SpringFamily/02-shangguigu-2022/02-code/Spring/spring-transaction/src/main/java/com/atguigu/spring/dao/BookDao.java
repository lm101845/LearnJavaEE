package com.atguigu.spring.dao;

/**
 * @Author liming
 * @Date 2023/1/8 13:21
 **/
public interface BookDao {
    /**
     * 根据图书id查询图书的价格
     * @param bookId
     * @return
     */
    Integer getPriceByBookId(Integer bookId);

    /**
     * 更新图书的库存
     * @param bookId
     */
    void updateStock(Integer bookId);

    /**
     * 更新用户的余额
     * @param userId
     * @param price
     */
    void updateBalance(Integer userId, Integer price);
}
