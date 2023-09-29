package com.atguigu.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @Author liming
 * @Date 2023/9/29 12:38
 **/

@Data
public class Product {
    private Long id;
    private String name;
    private Integer price;
    @Version
    //标识乐观锁版本号字段
    private Integer version;
}
