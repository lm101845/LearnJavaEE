package com.atguigu.boot3.core.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author liming
 * @Date 2023/10/3 9:44
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    private String username;
    private String password;
}
