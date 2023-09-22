package com.atguigu.spring6.validator.one;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @Author liming
 * @Date 2023/9/22 17:35
 **/

//这个看看就行，后面直接用注解了
public class PersonValidator implements Validator {
    //supports方法用来表示此校验用在哪个类型上，
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    //validate是设置校验逻辑的地点，其中ValidationUtils，是Spring封装的校验工具类，帮助快速实现校验。
    @Override
    public void validate(Object target, Errors errors) {
        //name不能为空
        ValidationUtils.rejectIfEmpty(errors,"name","name.empty~可以随便写","name is none");
        //age不能小于0，不能大于200
        Person p = (Person)target;
       if(p.getAge() < 0){
           errors.rejectValue("age","age.value.error","age < 0");
       }else if(p.getAge() > 200){
           errors.rejectValue("age","age.value.error.old","age > 200");
       }
    }
}
