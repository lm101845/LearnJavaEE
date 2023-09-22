package com.atguigu.boot.config;

import com.atguigu.boot.bean.Pig;
import com.atguigu.boot.bean.Sheep;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @Author liming
 * @Date 2023/9/23 3:49
 **/

@SpringBootConfiguration
/**
 * 1.开启sheep组件的属性绑定
 * 2.默认会把这个组件放到容器中
 *
 * 一般用于导入第三方写好的组件进行属性绑定
 * SpringBoot默认只扫描自己主程序所在的包。如果导入第三方包，
 * 即使组件上标注了 @Component、@ConfigurationProperties 注解，也没用。
 * 因为组件都扫描不进来，此时使用这个注解就可以快速进行属性绑定并把组件注册进容器
 */
@EnableConfigurationProperties(Sheep.class)
public class AppConfig3 {
    @Bean
    @ConfigurationProperties(prefix = "pig")
    public Pig pig(){
        return new Pig();
        //我们自己new的新pig
        //但因为我们在Pig.java上标注了@ConfigurationProperties(prefix = "pig")注解
        //所以这个组件放到容器中以后，容器会对它进行自动绑定(application.properties里面的值会绑定给它)
    }

}
