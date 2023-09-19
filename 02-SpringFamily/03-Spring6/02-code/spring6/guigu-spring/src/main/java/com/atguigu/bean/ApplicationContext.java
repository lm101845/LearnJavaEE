package com.atguigu.bean;

/**
 * @Author liming
 * @Date 2023/9/19 23:47
 **/

//这个ApplicationContext是我们自定义的接口
public interface ApplicationContext {
    Object getBean(Class clazz);
}
