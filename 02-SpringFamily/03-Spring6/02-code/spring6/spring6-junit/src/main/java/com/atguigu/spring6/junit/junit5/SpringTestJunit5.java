package com.atguigu.spring6.junit.junit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @Author liming
 * @Date 2023/9/21 15:21
 **/

//不常用写法：
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:bean.xml")
//常用写法：
@SpringJUnitConfig(locations = "classpath:bean.xml")
public class SpringTestJunit5 {
    //测试
    @Autowired
    private User user;

    //测试方法
    @Test
    public void testUser(){
        System.out.println(user);
        user.run();
    }
}
