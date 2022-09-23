package com.atguigu.maven;

import org.junit.Test;

/**
 * @Author liming
 * @Date 2022/9/23 16:17
 **/
public class HelloTest {
    @Test
    public void testHello(){
        Hello hello = new Hello();
        hello.showMessage();
    }
}
