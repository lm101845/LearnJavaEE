package com.atguigu.mybatisplus.pojo;

import lombok.Data;

/**
 * @Author liming
 * @Date 2023/9/30 12:26
 **/
@Data
public class Product {
    private Integer id;
    private String name;
    private Integer price;
    private Integer version;
}
