package com.atguigu.maven;

import com.atguigu.imperial.court.util.MD5Util;

public class StringTest {

    public static void main(String[] args) {

        String hello = MD5Util.encode("hello");
        System.out.println("hello = " + hello);

    }

}
