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

    /**
     * 批量删除功能
     * @param ids
     */
    void deleteMoreUser(@Param("ids") String ids);
    //ids是我们要删除的id,通过逗号拼接之后的结果

    /**
     * 动态设置表名，查询用户信息
     * @param tableName
     * @return
     */
    List<User> getUserList(@Param("tableName") String tableName);

    /**
     * 添加用户信息，并获取自增的主键
     * @param user
     */
    void insertUser(User user);
}
