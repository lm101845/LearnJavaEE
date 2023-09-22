package com.atguigu.boot.config;

//import com.alibaba.druid.FastsqlException;
import com.atguigu.boot.bean.User;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

/**
 * @Author liming
 * @Date 2023/9/23 2:17
 **/
//告诉SpringBoot这是一个配置类(替代以前的配置文件)
//@Configuration继承了@Component,配置类本身也是容器中的组件
//@Configuration


//使用@SpringBootConfiguration替代@Configuration,二者其实没啥区别
@SpringBootConfiguration

//自定义方法给容器中注册组件——写法2(使用@Import导入)
//给容器中放指定类型的组件，组件的名字默认是全类名
//@Import(FastsqlException.class)

public class AppConfig {
    /**
     * 组件默认是【单实例】的
     * @return
     */
    //@Bean
    @Bean("userHaHa")
    //@Bean用于替代以前的bean标签
    //【组件】在容器中的名字【默认】是方法名(可以通过修改注解的值【手动】改名)
    @Scope("prototype")
    //将组件改成多实例
    public User user(){
    //public User userHaHa2(){
        var user = new User();
        //Java中var是Java10版本新出的特性，用它来定义局部变量。
        user.setId(1L);
        user.setName("张三");
        return user;
    }


    //自定义方法给容器中注册组件——写法1：
    //@Bean
    //public FastsqlException fastsqlException(){
    //    return new FastsqlException();
    //}
}
