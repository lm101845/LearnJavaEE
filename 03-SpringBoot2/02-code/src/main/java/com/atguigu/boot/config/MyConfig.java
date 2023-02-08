package com.atguigu.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author liming
 * @Date 2023/2/8 22:24
 **/

/**
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods：代理bean的方法
 *      Full(proxyBeanMethods = true)、【保证每个@Bean方法被调用多少次返回的组件都是单实例的】
 *      Lite(proxyBeanMethods = false)【每个@Bean方法被调用多少次返回的组件都是新创建的】
 *      组件依赖必须使用Full模式默认。其他默认是否Lite模式
 *
 * 4、@Import({User.class, DBHelper.class})
 *      给容器中自动创建出这两个类型的组件、默认组件的名字就是全类名
 *
 *
 * 5、@ImportResource("classpath:beans.xml")导入Spring的配置文件，
 *
 */
@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = true)   //默认为true，单实例
//@Configuration(proxyBeanMethods = false)
//@ConditionalOnBean(name="tom")
@ConditionalOnMissingBean(name="tom")
//把这个配置标注在类上，说明如果这个组件中没有tom,则下面一堆都不会生效
//告诉SpringBoot这是一个配置类，等同于以前的配置文件
public class MyConfig {
    //@ConditionalOnBean(name="tom")
    @Bean
    //@Bean注解给容器中添加组件，以方法名作为组件的id，返回类型就是组件类型，方法返回的值，就是组件容器中保存的对象
    public User user01(){
        User zhangsan = new User("zhangsan", 18);
        //User组件依赖了Pet组件
        zhangsan.setPet(tom());
        return zhangsan;
    }


    //@Bean("tom")
    @Bean("tom22")
    public Pet tom(){
        return new Pet("tom");
    }
}
