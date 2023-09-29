package com.atguigu.mybatisplus.mapper;

import com.atguigu.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @Author liming
 * @Date 2023/9/23 14:01
 **/
@Repository
//强迫症，不想看到红线的解决方法
//泛型就是操作的实体类的类型
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据id查询用户信息为map集合
     * @param id
     * @return
     */
    Map<String,Object> selectMapById(Long id);

    /**
     * 根据年龄查询用户信息并分页
     * 底层他俩都差不多都是拦截器实现
     * @param page MyBatis-Plus所提供的分页对象,必须位于第一个参数的位置
     * @param age
     * @return
     */
    Page<User> selectPageVO(@Param("page") Page<User> page, @Param("age") Integer age);
}