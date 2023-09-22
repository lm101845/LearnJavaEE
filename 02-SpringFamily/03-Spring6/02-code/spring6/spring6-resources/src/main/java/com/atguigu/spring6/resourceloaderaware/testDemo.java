package com.atguigu.spring6.resourceloaderaware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ResourceLoader;

/**
 * @Author liming
 * @Date 2023/9/22 16:29
 **/
public class testDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        TestBean testBean = context.getBean("testBean", TestBean.class);
        ResourceLoader resourceLoader = testBean.getResourceLoader();
        //可以省空间，栈有多个引用，但堆只需要一个对象
        System.out.println(context == resourceLoader);
        //验证spring容器是否注入到了resourceLoader中了
    }
}
