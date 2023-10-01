package com.atguigu.securitydemo1.service;

import com.atguigu.securitydemo1.entity.Users;
import com.atguigu.securitydemo1.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author liming
 * @Date 2023/10/1 12:17
 **/
@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //调用userMapper里面的方法,根据用户名查询数据库
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        Users users = userMapper.selectOne(wrapper);
        if(users == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("role");
        //从查询数据库返回users对象，得到用户名和密码，返回
        return new User(users.getUsername(),new BCryptPasswordEncoder().encode(users.getPassword()),auths);
        //return new User("mary",new BCryptPasswordEncoder().encode("123"),auths);
    }
}
