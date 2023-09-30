package com.atguigu.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author liming
 * @Date 2023/9/30 12:22
 **/
@Data
@TableName("t_user")
public class User {
    @TableId
    private Long uid;


    private String userName;

    private Integer age;


    private String email;

    private Integer sex;

    private Integer isDeleted;
}
