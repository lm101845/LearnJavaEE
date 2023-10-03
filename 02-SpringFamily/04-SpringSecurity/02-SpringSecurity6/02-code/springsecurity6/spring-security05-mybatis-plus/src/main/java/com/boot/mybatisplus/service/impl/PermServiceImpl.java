package com.boot.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.mybatisplus.entity.Perm;
import com.boot.mybatisplus.entity.User;
import com.boot.mybatisplus.mapper.PermMapper;
import com.boot.mybatisplus.mapper.UserMapper;
import com.boot.mybatisplus.service.PermService;
import com.boot.mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author liming
 * @Date 2023/10/3 16:51
 **/
@Service
public class PermServiceImpl extends ServiceImpl<PermMapper, Perm> implements PermService, UserDetailsService {
    @Autowired
    PermMapper permMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //    QueryWrapper<Perm> queryWrapper = new QueryWrapper<>();
        //    queryWrapper.eq("username",username);
        //    Perm perm = permMapper.selectOne(queryWrapper);
        //    if(perm == null){
        //        throw new UsernameNotFoundException("用户未找到");
        //    }
        //    return perm;
        //}
        return null;
    }
}
