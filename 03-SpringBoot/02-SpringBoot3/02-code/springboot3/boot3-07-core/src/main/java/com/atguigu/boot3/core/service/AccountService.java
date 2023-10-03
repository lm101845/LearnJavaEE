package com.atguigu.boot3.core.service;

import org.springframework.stereotype.Service;

/**
 * @Author liming
 * @Date 2023/10/3 9:25
 **/

//写法1：
@Service
public class AccountService {
    public void addAccountScore(String username){
        System.out.println(username + "加了一分积分");
    }
}
