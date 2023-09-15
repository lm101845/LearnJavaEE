package com.atguigu.spring6;

/**
 * @Author liming
 * @Date 2023/9/15 20:40
 **/
public class User {
    //无参构造函数

    public User() {
        System.out.println("0:无参构造函数执行了");
    }

    public void add(){
        System.out.println("add方法执行了...");
    }

    //传统方式是这么调用方法的(必须先创建类的实例)
    //public static void main(String[] args) {
    //    User user = new User();
    //    user.add();
    //}
}
