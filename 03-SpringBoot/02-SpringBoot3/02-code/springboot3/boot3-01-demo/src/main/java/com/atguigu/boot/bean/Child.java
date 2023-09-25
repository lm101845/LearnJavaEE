package com.atguigu.boot.bean;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author liming
 * @Date 2023/9/24 16:09
 **/

@Data
public class Child {
    private String name;
    private Integer age;
    private Date birthDay;
    private List<String> text;   //数组类型的文本
}
