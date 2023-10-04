package com.atguigu.boot3.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author liming
 * @Date 2023/10/4 22:46
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
//对象要实现序列化接口，不然不能序列化，无法进行网络传送
public class Person implements Serializable {
    private Long id;
    private String name;
    private int age;
    private Date birthDay;
}
