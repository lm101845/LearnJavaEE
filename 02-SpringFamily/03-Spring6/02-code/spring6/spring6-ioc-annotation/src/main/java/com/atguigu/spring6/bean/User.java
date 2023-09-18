package com.atguigu.spring6.bean;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @Author liming
 * @Date 2023/9/18 17:34
 **/
//@Component(value = "user")
//类似于 <bean id="user class="com.atguigu.spring6.bean.User"/>
@Component
//value可以不写，默认值就是User(首字母自动改成小写)

//@Repository
//@Service
//使用@Component、@Repository、@Service、@Controller效果都一样，只不过习惯见名知意
public class User {

}
