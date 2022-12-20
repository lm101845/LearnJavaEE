package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author liming
 * @Date 2022/12/20 10:18
 **/
public interface SpecialSQLMapper {
    /**
     * 通过用户名模糊查询用户信息
     * @param mohu
     * @return
     */
    List<User> getUserByLike( @Param("mohu") String mohu);
}
