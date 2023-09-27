package com.atguigu.boot3.ssm.mapper;

import com.atguigu.boot3.ssm.bean.TUser;
import org.apache.ibatis.annotations.Param;

/**
 * @Author liming
 * @Date 2023/9/27 23:59
 **/
public interface UserMapper {
    /**
     * 每一个方法都在Mapper文件中有一个sql标签对应
     * 所有参数都应该用@Param进行签名，以后使用指定的名字在SQL中取值
     * @param id
     * @return
     */
    public TUser getUserById(@Param("id") Long id);
}
