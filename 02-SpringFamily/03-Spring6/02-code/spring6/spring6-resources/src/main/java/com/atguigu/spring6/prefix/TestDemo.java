package com.atguigu.spring6.prefix;


import com.atguigu.spring6.di.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

/**
 * @Author liming
 * @Date 2023/9/22 16:51
 **/
public class TestDemo {
    public static void main(String[] args) {
        //ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean*.xml");
        //Resource resource = context.getResource("atguigu.txt");
        //System.out.println(resource.getDescription());


        //加完*,就找所有以bean开头的xml了
        //老师其实讲的是spring是怎么解读这些文件的，为什么指定一个文件，spring就能实现相应的功能，而使用File就实现不了
        User user = context.getBean(User.class);
        System.out.println(user);
    }
}
