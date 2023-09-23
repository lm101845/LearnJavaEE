package com.atguigu.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.atguigu.mybatisplus.mapper")
//我这个之前写成了@MapperScan("com.atguigu.mybatisplus.mapper.UserMapper")，导致空指针异常了......
//扫描mapper接口所在的包
public class MybatisplusApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisplusApplication.class, args);
    }

}
