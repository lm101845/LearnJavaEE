package com.atguigu.boot;

//import com.alibaba.druid.FastsqlException;
import com.atguigu.boot.bean.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


//主程序：com.atguigu.boot(SpringBoot只会扫描主程序所在的包及其下面的子包，自动的component-scan功能)
//@SpringBootApplication
//扫描规则方法1：
@SpringBootApplication(scanBasePackages = "com.atguigu")
//扫描规则方法2：直接指定扫描路径
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan("com.atguigu")
public class MainApplication {

    public static void main(String[] args) {
        //SpringApplication.run(Boot302DemoApplication.class, args);

        //java10： 局部变量类型的自动推断
        var ioc = SpringApplication.run(MainApplication.class, args);

        //1、获取容器中所有组件的名字
        String[] names = ioc.getBeanDefinitionNames();
        //2、挨个遍历：
        // dispatcherServlet、beanNameViewResolver、characterEncodingFilter、multipartResolver
        // SpringBoot把以前配置的核心组件现在都给我们自动配置好了。
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("===================");

        String[] forType = ioc.getBeanNamesForType(User.class);
        //for (String s : forType) {
        //    System.out.println(s);
        //}

        System.out.println("========验证単实例===========");
        Object userHaHa1 = ioc.getBean("userHaHa");
        Object userHaHa2 = ioc.getBean("userHaHa");
        System.out.println(userHaHa1 == userHaHa2);   //true   false

        System.out.println("=========验证自定义方法给容器中注册组件==================");
        //String[] fastsqlException = ioc.getBeanNamesForType(FastsqlException.class);
        //for (String s : fastsqlException) {
        //    System.out.println(s);
        //}
        System.out.println("=========验证条件注解@ConditionalOnClass==================");
        for (String s : ioc.getBeanNamesForType(Cat.class)) {
            System.out.println("cat:" + s);
        }

        for (String s : ioc.getBeanNamesForType(Dog.class)) {
            System.out.println("dog:" + s);
        }

        System.out.println("=========验证条件注解@ConditionalOnBean==================");
        for (String s : ioc.getBeanNamesForType(User.class)) {
            System.out.println("user:" + s);
        }

        System.out.println("=========验证属性绑定@ConfigurationProperties==================");
        Pig pig = ioc.getBean(Pig.class);
        System.out.println("pig:"+ pig);

        System.out.println("=========验证快速注册注解EnableConfigurationProperties===========");
        Sheep sheep = ioc.getBean(Sheep.class);
        System.out.println("sheep:"+ sheep);

    }

}
