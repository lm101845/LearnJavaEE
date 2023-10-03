package com.boot.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.mybatisplus.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author liming
 * @Date 2023/10/3 16:48
 **/

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
