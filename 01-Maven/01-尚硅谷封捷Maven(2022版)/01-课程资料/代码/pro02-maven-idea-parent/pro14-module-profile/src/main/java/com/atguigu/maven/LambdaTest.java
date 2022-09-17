package com.atguigu.maven;

public class LambdaTest {

    public static void main(String[] args) {

        new Thread(()->{
            System.out.println("hello");
        }).start();

    }

}
