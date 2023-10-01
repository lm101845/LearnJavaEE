package com.atguigu.boot3.features.bean;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @Author liming
 * @Date 2023/9/23 2:14
 **/
@Profile({"dev"})
@Component
public class Cat {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
