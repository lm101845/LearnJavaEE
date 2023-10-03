package com.boot.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.mybatisplus.entity.Perm;
import com.boot.mybatisplus.entity.User;
import com.boot.mybatisplus.mapper.PermMapper;
import com.boot.mybatisplus.mapper.UserMapper;
import com.boot.mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author liming
 * @Date 2023/10/3 16:51
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService, UserDetailsService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    PermMapper permMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        User user = userMapper.selectOne(queryWrapper);
        if(user == null){
            throw new UsernameNotFoundException("用户未找到");
        }

        //根据用户名查找权限
        QueryWrapper<Perm> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("user_id",user.getId());

        List<Perm> perms = permMapper.selectList(queryWrapper1);

        //权限标识
        List<String> permTags = perms.stream().map(Perm::getTag).collect(Collectors.toList());
        user.setAuthorityList(AuthorityUtils.createAuthorityList(permTags));
        return user;
    }
}
