package com.itheima;

import com.itheima.dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author liming
 * @Date 2022/11/14 14:30
 **/
public class AppForLifeCycle {
    public static void main(String[] args) {
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //ApplicationContext类没有close方法

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        //注册关闭钩子函数，在虚拟机退出之前回调此函数，关闭容器(比较温和)——在任何位置写都可以
        //ctx.registerShutdownHook();
        //实际中关闭容器不需要我们写，Web项目中用tomcat来帮我们关

        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        bookDao.save();
        //关闭容器——比较暴力
        ctx.close();
    }
}
