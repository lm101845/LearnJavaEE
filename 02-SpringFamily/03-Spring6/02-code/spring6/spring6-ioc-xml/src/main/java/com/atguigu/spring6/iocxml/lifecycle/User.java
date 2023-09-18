package com.atguigu.spring6.iocxml.lifecycle;

/**
 * @Author liming
 * @Date 2023/9/18 15:49
 **/
public class User {
    public User() {
        System.out.println("1：调用无参构造，创建bean对象");
    }

    //初始化的方法(名字随便起)
    public void initMethod(){
        System.out.println("4:bean对象初始化，调用指定的初始化方法");
    }

    //销毁的方法(名字随便起)
    //注意：只有scope是singleton时，容器才会在close方法中调用bean的destroy方法。
    public void destroryMethod(){
        System.out.println("5:bean对象销毁，调用指定的销毁方法");
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("2:给bean对象设置属性");
        this.name = name;
    }
}
