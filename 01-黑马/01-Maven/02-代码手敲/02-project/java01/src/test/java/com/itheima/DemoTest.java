package com.itheima;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author 李明
 * @date 2021年07月02日 11:10
 */
public class DemoTest {
    @Test
    public void testSay(){
        Demo d = new Demo();
        String ret = d.say("太阳");
        Assert.assertEquals("hello啊 太阳",ret);
    }
}
