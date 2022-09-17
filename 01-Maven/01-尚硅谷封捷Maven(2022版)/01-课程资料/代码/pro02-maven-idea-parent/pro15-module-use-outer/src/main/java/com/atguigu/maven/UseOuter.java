package com.atguigu.maven;

public class UseOuter {

    public static void main(String[] args) {
        OutClass outClass = new OutClass();
        String name = outClass.getName();
        System.out.println("name = " + name);
    }

}
