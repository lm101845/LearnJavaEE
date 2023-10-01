package com.atguigu.securitydemo1.mapper;

import com.atguigu.securitydemo1.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @Author liming
 * @Date 2023/10/1 12:57
 **/

@Repository
public interface UserMapper extends BaseMapper<Users> {
}
