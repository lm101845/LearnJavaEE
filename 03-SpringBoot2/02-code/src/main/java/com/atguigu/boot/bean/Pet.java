package com.atguigu.boot.bean;

/**
 * @Author liming
 * @Date 2023/2/8 22:17
 **/
public class Pet {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                '}';
    }

    public Pet() {
    }

    public Pet(String name) {
        this.name = name;
    }
}
