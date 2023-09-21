package com.atguigu.spring6.txwithzhujie;

import com.atguigu.spring6.txwithzhujie.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @Author liming
 * @Date 2023/9/21 17:54
 **/

@SpringJUnitConfig(locations = "classpath:beans2.xml")
public class TestBookTx {
    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook(){
        bookController.buyBook(1,1);
    }

    @Test
    public void testBuyBookUsePropagation(){
        Integer[] bookIds = {1,2};
        bookController.checkout(bookIds,1);
    }
}
