package com.atguigu.boot3.features.service;

import org.springframework.stereotype.Service;

/**
 * @Author liming
 * @Date 2023/10/2 13:10
 **/
@Service
public class HelloService {
    public int sum(int a,int b){
        return a + b;
    }
}
