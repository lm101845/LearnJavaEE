package com.atguigu.spring6.srpingI18n;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Locale;

/**
 * @Author liming
 * @Date 2023/9/22 17:23
 **/
public class ResourceI18n {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Object[] objs = new Object[]{"atguigu",new Date().toString()};
        String value = context.getMessage("www.atguigu.com", objs, Locale.CHINA);
        System.out.println(value);
        //翻译文本的解耦，然后翻译工作就可以外包了，包括游戏汉化等等
    }
}
