package com.atguigu.spring6.validator.two;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author liming
 * @Date 2023/9/23 0:34
 **/
public class TestUser {
    @Test
    public void testValidationOne(){
        ApplicationContext context = new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyValidation1 validation1 = context.getBean(MyValidation1.class);
        User user = new User();
        user.setName("lucy");
        user.setAge(-1);
        boolean message = validation1.validatorByUser(user);
        System.out.println(message);
    }

    @Test
    public void testValidationTwo(){
        ApplicationContext context = new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyValidation2 validation2 = context.getBean(MyValidation2.class);
        //这里讲的有问题，validation2名字为空的报错是因为new BindException传的参数为空，其实没必要传getName，
        //自己定义就好，这样名字为空的时候不会抛错，会返回true
        User user = new User();
        user.setName("tom");
        //user.setAge(-1);
        user.setAge(130);
        boolean message = validation2.validatorByUserTwo(user);
        System.out.println(message);
    }
}
