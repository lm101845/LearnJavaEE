package com.atguigu.spring6.validator.three;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author liming
 * @Date 2023/9/23 0:48
 **/
public class TestUser {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyService service = context.getBean(MyService.class);
        User user = new User();
        user.setName("tom");
        //user.setAge(-1);
        user.setAge(130);
        user.setPhone("18512345685");
        //user.setMessage("test a t guigu");    //自定义校验规则：不能包含空格生效了
        service.testMethod(user);
    }
}
