package com.atguigu.boot3.core.service;

import org.springframework.stereotype.Service;

/**
 * @Author liming
 * @Date 2023/10/3 9:28
 **/

@Service
public class SysService {
    public void recordLog(String username){
        System.out.println(username + "登录信息已被记录");
    }
}
