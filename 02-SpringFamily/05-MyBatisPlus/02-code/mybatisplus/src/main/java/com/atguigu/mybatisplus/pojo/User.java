package com.atguigu.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;
import org.springframework.stereotype.Service;

/**
 * @Author liming
 * @Date 2023/9/23 13:41
 **/

//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@EqualsAndHashCode
@Data
//@TableName("t_user")
//设置实体类所对应的表名
public class User {
    //情况二：类名属性叫id,但MySQL数据库主键叫uid
    //@TableId注解的value属性用于指定主键的字段
    //@TableId(value = "uid")

    //情况三：设置主键自动递增，而不是雪花算法
    //还需要把数据库设置主键自动递增并且截断表一下
    @TableId(value = "uid" ,type= IdType.AUTO)
    private Long id;

    //情况一：主键为uid
    //@TableId
    //将属性所对应的字段指定为主键
    //private Long uid;

    @TableField("user_name")
    //指定属性所对应的非主键字段名
    private String name;
    //private String userName;
    //数据库中使用的字段名是user_name,使用驼峰，可以自动识别
    //mybatis-plus里面有一个默认配置，可以自动将下划线转换为相应的驼峰
    private Integer age;

    private String email;

    private Enum sex;

    //逻辑删除
    @TableLogic
    private Integer isDeleted;
}
