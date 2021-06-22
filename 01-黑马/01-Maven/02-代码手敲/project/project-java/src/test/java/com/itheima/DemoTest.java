package com.itheima;
import org.junit.Test;
import org.junit.Assert;

public class DemoTest{
    @Test
    public void testSay(){
        Demo d = new Demo();
        String ret = d.say("maven");
        // Assert：断言
        // Assert.assertEquals(预计值，真实值)
        Assert.assertEquals("hello maven",ret);
    }
}
