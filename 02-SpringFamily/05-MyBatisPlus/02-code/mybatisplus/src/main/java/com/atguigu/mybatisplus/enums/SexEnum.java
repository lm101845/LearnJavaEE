package com.atguigu.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @Author liming
 * @Date 2023/9/29 13:15
 **/

@Getter
//枚举是一个常量，只需要设置get值即可
public enum SexEnum {
    MALE(1, "男"),
    FEMALE(2, "女");

    //将注解所标识的属性的值存储到数据库中
    @EnumValue
    private Integer sex;
    private String sexName;

    SexEnum(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
}
