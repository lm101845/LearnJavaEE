package com.atguigu.spring6.txwithzhujie;

import com.atguigu.spring6.txwithzhujie.config.SpringConfig;
import com.atguigu.spring6.txwithzhujie.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author liming
 * @Date 2023/9/21 23:07
 **/
public class TestAnno {
    @Test
    public void testTxAllAnnotation(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookController accountService = applicationContext.getBean("bookController", BookController.class);
        accountService.buyBook(1, 1);
    }
}
