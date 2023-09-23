package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

/**
 * @Author liming
 * @Date 2023/9/23 14:10
 **/

@SpringBootTest
public class MyBatisPlusTest {

    @Autowired
    private UserMapper userMapper;
    //报红线，其实没事

    @Test
    public void testSelectList(){
        //通过条件构造器查询一个list集合,若没有条件，则可以设置参数为null
        //List<User> list = userMapper.selectList(null);
        //list.forEach(System.out::println);

        userMapper.selectList(null).forEach(System.out::println);
    }
}
