package com.atguigu.spring6.aop.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Author liming
 * @Date 2023/9/20 15:29
 * 我第一次学动态代理是在2022/8/20 13:21，看的宋红康康师傅的JavaSE，现在又学了一遍，感觉好一些了
 **/
public class ProxyFactory {
    //target目标对象——歌星(Object表示通用)
    private Object target;

    //把目标对象用构造方法传入
    public ProxyFactory(Object target) {
        this.target = target;
        //经纪人 = 歌星
    }

    //使用动态代理返回代理对象(经纪人)——根据歌星的不同，返回给你不同的经纪人
    public Object getProxy(){
        /**
         * Proxy.newProxyInstance()方法的三个参数：
         *  1、classLoader：加载动态生成的代理类的类加载器
         *  2、interfaces：目标对象实现的所有接口的class对象所组成的数组
         *  3、invocationHandler：设置代理对象实现目标对象方法的过程，即代理类中如何重写接口中的抽象方法
         *  (第三个参数就是拿来重写目标对象中实现的接口方法的，返回值就是一个动态生成的代理类)
         */

        /**
         要想实现动态代理，需要解决的问题？
         问题一：如何根据加载到内存中的被代理类(歌星)，动态的创建一个代理类(经纪人)及其对象。
         问题二：当通过代理类(经纪人)的对象调用方法a时，如何动态的去调用被代理类(歌星)中的同名方法a。
         */
        ClassLoader classLoader = target.getClass().getClassLoader();   //歌星的类加载器
        Class<?>[] interfaces = target.getClass().getInterfaces();
        //lambda表达式是实现函数式接口的实现类对象。
        InvocationHandler invocationHandler = new InvocationHandler(){
            /**
             * 参数说明：
             * proxy：代理对象(经纪人)
             * method：代理对象需要实现的方法，即其中需要重写的方法
             * args：method所对应方法的参数
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //方法调用之前输出
                System.out.println("[动态代理][日志] "+method.getName()+"，参数："+ Arrays.toString(args));
                //调用目标(歌星)的方法
                Object result = method.invoke(target, args);
                System.out.println("[动态代理][日志] "+method.getName()+"，结果："+ result);
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);
    }
}
