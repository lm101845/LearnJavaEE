package com.atguigu.spring6.aop.example;

/**
 * @Author liming
 * @Date 2023/9/20 15:11
 **/

//静态代理
public class CalculatorStaticProxy implements Calculator{

    //把被代理的目标对象传递过来
    private Calculator calculator;

    //构造方法
    public CalculatorStaticProxy(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int add(int i, int j) {
        /**
         * 静态代理确实实现了解耦，但是由于代码都写死了，完全不具备任何的灵活性。
         * 就拿日志功能来说，将来其他地方也需要附加日志，那还得再声明更多个静态代理类，
         * 那就产生了大量重复的代码，日志功能还是分散的，没有统一管理。
         */

        //之前输出日志
        System.out.println("[日志] add 方法开始了，参数是：" + i + "," + j);
        //调用目标对象的方法实现核心
        int addResult = calculator.add(i, j);   //这种写法我要慢慢熟悉啊！！！
        //之后输出日志
        System.out.println("[日志] add 方法结束了，结果是：" + addResult);
        return 0;
    }

    @Override
    public int sub(int i, int j) {
        return 0;
    }

    @Override
    public int mul(int i, int j) {
        return 0;
    }

    @Override
    public int div(int i, int j) {
        return 0;
    }
}
