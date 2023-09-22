package com.atguigu.spring6.validator.one;

import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

/**
 * @Author liming
 * @Date 2023/9/22 17:42
 **/
public class TestPerson {
    public static void main(String[] args) {
        //创建person对象
        Person person = new Person();
        person.setName("zhangsan");
        //person.setAge(-1);
        person.setAge(250);
        //创建person对应databinder
        DataBinder binder = new DataBinder(person);
        //设置校验器
        binder.setValidator(new PersonValidator());
        //调用方法执行校验
        binder.validate();
        //输出校验结果
        BindingResult result = binder.getBindingResult();
        System.out.println(result.getAllErrors());
    }
}
