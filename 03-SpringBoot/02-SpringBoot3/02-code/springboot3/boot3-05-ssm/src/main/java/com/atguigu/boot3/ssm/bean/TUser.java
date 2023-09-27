package com.atguigu.boot3.ssm.bean;

import lombok.Data;

/**
 * @Author liming
 * @Date 2023/9/27 23:58
 **/

@Data
public class TUser {
    private Long id;
    private String loginName;
    private String nickName;
    private String passwd;
}
