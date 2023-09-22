package com.atguigu.boot.config;

//import com.alibaba.druid.FastsqlException;
import com.atguigu.boot.bean.Cat;
import com.atguigu.boot.bean.Dog;
import com.atguigu.boot.bean.User;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;

/**
 * @Author liming
 * @Date 2023/9/23 2:57
 **/
@SpringBootConfiguration
//@ConditionalOnClass(name = "com.alibaba.druid.FastsqlException")
//如果放在【类级别】，如果注解判断生效，则整个配置类【才】生效

public class AppConfig2 {
    //条件注解：如果类路径中存在这个类，则触发指定行为
    //条件注解放在【方法】级别，则单独对这个方法进行注解判断
    @ConditionalOnClass(name = "com.alibaba.druid.FastsqlException")
    @Bean
    public Cat cat01(){
        return new Cat();
    }

    //条件注解：如果类路径中不存在这个类，则触发指定行为
    @ConditionalOnMissingClass(value = "com.alibaba.druid.FastsqlException")
    @Bean
    public Dog dog01(){
        return new Dog();
    }

    //条件注解：如果容器中存在这个Bean（组件），则触发指定行为
    @ConditionalOnBean(value = Dog.class)
    @Bean
    public User zhangsan(){
        return new User();
    }

    //如果容器中不存在这个Bean（组件），则触发指定行为
    @ConditionalOnMissingBean(value = Dog.class)
    @Bean
    public User lisi(){
        return new User();
    }
}
