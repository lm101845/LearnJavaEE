package com.atguigu.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author liming
 * @Date 2023/9/24 16:07
 **/

@Component
@ConfigurationProperties(prefix = "person")
//和配置文件person前缀的所有配置进行绑定
@Data
//自动生成javaBean属性的getter/setter
//@NoArgsConstructor   //自动生成无参构造器
//@AllArgsConstructor  //自动生成全参构造器
public class Person {
    private String name;
    private Integer age;
    private Date birthDay;
    private Boolean like;
    private Child child;            //嵌套对象
    private List<Dog> dogs;         //数组（里面是对象）
    private Map<String,Cat> cats;  //表示Map
}
