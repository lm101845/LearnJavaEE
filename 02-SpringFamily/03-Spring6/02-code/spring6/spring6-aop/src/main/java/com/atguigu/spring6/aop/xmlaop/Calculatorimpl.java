package com.atguigu.spring6.aop.xmlaop;

import org.springframework.stereotype.Component;

/**
 * @Author liming
 * @Date 2023/9/20 14:30
 **/

//基本实现类
@Component
public class Calculatorimpl implements Calculator {
    @Override
    public int add(int i, int j) {

        int result = i + j;
        System.out.println("方法内部 result = " + result);
        //为了测试，模拟异常的出现
        //int a = 1 / 0;
        return result;
    }

    @Override
    public int sub(int i, int j) {

        int result = i - j;
        System.out.println("方法内部 result = " + result);
        return result;
    }

    @Override
    public int mul(int i, int j) {

        int result = i * j;
        System.out.println("方法内部 result = " + result);
        return result;
    }

    @Override
    public int div(int i, int j) {

        int result = i / j;
        System.out.println("方法内部 result = " + result);
        return result;
    }
}
