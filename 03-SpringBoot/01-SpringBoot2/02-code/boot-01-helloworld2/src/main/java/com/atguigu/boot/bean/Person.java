package com.atguigu.boot.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author liming
 * @Date 2023/2/10 11:19
 **/
@ConfigurationProperties(prefix = "person")
//这个注解是优先用application.properties配置文件还是优先用application.yaml呢
//我试了一下，如果是同一个属性，application.properties会把application.yaml的覆盖掉
@Component
@Data
public class Person {
    private String userName;
    private Boolean boss;
    private Date birth;
    private Integer age;
    private Pet pet;
    private String[] interests;
    private List<String> animal;
    private Map<String, Object> score;
    private Set<Double> salarys;
    private Map<String, List<Pet>> allPets;
}
