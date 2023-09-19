package com.atguigu.reflect;

/**
 * @Author liming
 * @Date 2023/9/19 22:21
 **/
public class Car {
    //三个属性
    private String name;
    private int age;
    private String color;

    public Car() {
    }

    public Car(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    private Car(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //普通方法
    private void run() {
        System.out.println("私有方法-run执行了......");
    }

    //get和set方法
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
