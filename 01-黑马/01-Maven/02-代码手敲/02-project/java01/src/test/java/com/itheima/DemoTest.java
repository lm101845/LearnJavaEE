package com.itheima;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author ����
 * @date 2021��07��02�� 11:10
 */
public class DemoTest {
    @Test
    public void testSay(){
        Demo d = new Demo();
        String ret = d.say("̫��");
        Assert.assertEquals("hello�� ̫��",ret);
    }
}
