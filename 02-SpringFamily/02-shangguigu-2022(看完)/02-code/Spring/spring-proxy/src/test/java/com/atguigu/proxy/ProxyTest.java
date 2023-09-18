package com.atguigu.proxy;

import com.atguigu.spring.proxy.Calculator;
import com.atguigu.spring.proxy.CalculatorPureImpl;
import com.atguigu.spring.proxy.CalculatorStaticProxy;
import com.atguigu.spring.proxy.ProxyFactory;
import org.junit.Test;

/**
 * @Author liming
 * @Date 2023/1/7 12:36
 **/
public class ProxyTest  {
    /**
     * 动态代理有两种：
     * 1、jdk动态代理，要求必须有接口，最终生成的代理类和目标类实现相同的接口
     * 在com.sun.proxy包下，类名为$proxy2
     * 2、cglib动态代理，最终生成的代理类会继承目标类，并且和目标类在相同的包下
     */
    @Test
    public void testProxy(){
        //静态代理
        CalculatorStaticProxy proxy = new CalculatorStaticProxy(new CalculatorPureImpl());
        proxy.add(1,2);

        System.out.println("=========================");
        //动态代理
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorPureImpl());
        Calculator proxy1 = (Calculator) proxyFactory.getProxy();
        proxy1.add(1,2);
        //proxy1.div(1,0);
    }
}
