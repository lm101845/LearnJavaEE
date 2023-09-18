package com.atguigu.spring.proxy;

/**
 * @Author liming
 * @Date 2023/1/7 12:23
 **/
public class CalculatorStaticProxy implements Calculator{
    //代理类一定要和目标类实现相同的接口
    private CalculatorPureImpl target;

    public CalculatorStaticProxy(CalculatorPureImpl target) {
        this.target = target;
    }

    @Override
    public int add(int i, int j) {
        int addResult = 0;
        try {
            // 附加功能由代理类中的代理方法来实现
            System.out.println("[日志] add 方法开始了，参数是：" + i + "," + j);
            // 通过目标对象来实现核心业务逻辑
            addResult = target.add(i, j);
            System.out.println("[日志] add 方法结束了，结果是：" + addResult);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("代码执行结束了");
        }
        return addResult;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("[日志] sub 方法开始了，参数是：" + i + "," + j);
        int addResult = target.sub(i, j);
        System.out.println("[日志] sub 方法结束了，结果是：" + addResult);
        return addResult;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("[日志] mul 方法开始了，参数是：" + i + "," + j);
        int addResult = target.mul(i, j);
        System.out.println("[日志] mul 方法结束了，结果是：" + addResult);
        return addResult;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("[日志] div 方法开始了，参数是：" + i + "," + j);
        int addResult = target.div(i, j);
        System.out.println("[日志] div 方法结束了，结果是：" + addResult);
        return addResult;
    }
}
