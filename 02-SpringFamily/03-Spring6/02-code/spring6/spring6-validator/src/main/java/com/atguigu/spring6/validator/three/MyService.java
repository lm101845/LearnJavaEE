package com.atguigu.spring6.validator.three;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * @Author liming
 * @Date 2023/9/23 0:47
 **/
@Service
@Validated
public class MyService {
    public String testMethod(@NotNull @Valid User user){
        return user.toString();
    }
}
