package com.atguigu.mybatisplus.service.impl;

import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import com.atguigu.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Author liming
 * @Date 2023/9/25 23:55
 **/
//UserService接口继承了IService接口，可以直接使用该接口中的默认方法
//public class UserServiceImpl implements UserService {
//这样写我们既能继承通用service所实现的功能，也能使用自定义的功能
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
