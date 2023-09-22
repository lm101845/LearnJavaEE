package com.atguigu.spring6.validator.two;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;

import java.util.List;

/**
 * @Author liming
 * @Date 2023/9/23 0:31
 **/

//spring里面的校验器
@Service
public class MyValidation2 {
    @Autowired
    private Validator validator;

    public boolean validatorByUserTwo(User user){
        BindException bindException = new BindException(user,user.getName());
        //这里讲的有问题，validation2名字为空的报错是因为new BindException传的参数为空，其实没必要传getName，
        //自己定义就好，这样名字为空的时候不会抛错，会返回true
        validator.validate(user,bindException);
        List<ObjectError> allErrors = bindException.getAllErrors();
        System.out.println(allErrors);
        return bindException.hasErrors();
    }
}
