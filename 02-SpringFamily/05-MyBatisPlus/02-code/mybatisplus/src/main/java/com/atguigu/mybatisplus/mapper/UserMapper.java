package com.atguigu.mybatisplus.mapper;

import com.atguigu.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author liming
 * @Date 2023/9/23 14:01
 **/
@Repository
//强迫症，不想看到红线的解决方法
public interface UserMapper extends BaseMapper<User> {
    //泛型就是操作的实体类的类型
}