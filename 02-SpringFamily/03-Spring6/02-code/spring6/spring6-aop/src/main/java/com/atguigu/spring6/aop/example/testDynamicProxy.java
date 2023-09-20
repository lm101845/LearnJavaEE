package com.atguigu.spring6.aop.example;

import org.junit.jupiter.api.Test;

/**
 * @Author liming
 * @Date 2023/9/20 16:11
 **/
public class testDynamicProxy {
    @Test
   public void test(){
        ProxyFactory factory = new ProxyFactory(new Calculatorimpl());   //最基本的计算器
        //返回的就是代理对象
        Calculator proxy = (Calculator) factory.getProxy();
        proxy.add(1,2);
        //proxy.div(1,1);
    }
}
