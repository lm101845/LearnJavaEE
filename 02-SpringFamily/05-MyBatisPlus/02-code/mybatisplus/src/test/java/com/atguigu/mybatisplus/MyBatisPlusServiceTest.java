package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.pojo.User;
import com.atguigu.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author liming
 * @Date 2023/9/26 0:00
 **/
//===================================Service CRUD 接口提供的方法=========================================

@SpringBootTest
public class MyBatisPlusServiceTest {
    @Autowired
    //报错不用管，没问题
    private UserService userService;

    @Test
    public void testGetCount(){
        //查询总记录数
        //SELECT COUNT( * ) AS total FROM user
        long count = userService.count();
        System.out.println("总记录数:" + count);
    }

    @Test
    public void testSaveBatch(){
        //批量添加
        //INSERT INTO user ( id, name, age ) VALUES ( ?, ?, ? )
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("ybc" + i);
            user.setAge(20 + i);
            list.add(user);
        }
        boolean b = userService.saveBatch(list);
        System.out.println(b);
    }
}
