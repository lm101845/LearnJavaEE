package com.atguigu.spring6.validator.two;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * @Author liming
 * @Date 2023/9/23 0:28
 **/
public class User {
    @NotNull
    private String name;

    @Min(0)
    @Max(150)
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
