package com.atguigu.boot;

/**
 * @Author liming
 * @Date 2023/2/4 18:59
 **/


import ch.qos.logback.core.db.DBHelper;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import com.atguigu.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.cache.interceptor.CacheAspectSupport;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**主程序类
 * @SpringBootApplication：这是一个SpringBoot应用
 */
//@SpringBootApplication(scanBasePackages = "com.atguigu")
//把包的层级放到了，com.atguigu外面的包也可以扫描到了

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.atguigu.boot")

//@SpringBootApplication
//下面的一个注解 = 上面的三个注解
public class MainApplication {
    public static void main(String[] args) {
        //返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        //2.查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name:names){
            System.out.println(name);
        }

        int beanDefinitionCount = run.getBeanDefinitionCount();
        System.out.println("数量" + beanDefinitionCount);

        String[] beanNamesForType = run.getBeanNamesForType(CacheAspectSupport.class);
        System.out.println("======"+beanNamesForType.length);

        ////3.从容器中获取组件
        String[] beanNamesForType1 = run.getBeanNamesForType(WebMvcProperties.class);
        System.out.println("======"+beanNamesForType1.length);
        //Object tom01 = run.getBean("tom", Pet.class);
        //Object tom02 = run.getBean("tom", Pet.class);
        //System.out.println("组件："+(tom01 == tom02));  //true,它是单例的
        //
        //MyConfig bean = run.getBean(MyConfig.class);
        //System.out.println(bean);
        ////4.com.atguigu.boot.config.MyConfig$$EnhancerBySpringCGLIB$$8bf3abac@1e7f2e0f
        ////配置类本身也是组件
        //
        ////如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中有。
        ////保持组件单实例
        //User user01 = bean.user01();
        //User user02 = bean.user01();
        //System.out.println(user01 == user02);  //true
        //
        //User user = run.getBean("user01", User.class);
        //Pet tom = run.getBean("tom", Pet.class);
        //System.out.println("用户的宠物："+(user.getPet() == tom));
        //
        ////5、获取组件
        //String[] beanNamesForType = run.getBeanNamesForType(User.class);
        //System.out.println("======");
        //for (String s : beanNamesForType) {
        //    System.out.println(s);
        //}
        //DBHelper bean1 = run.getBean(DBHelper.class);
        //System.out.println(bean1);

        boolean tom = run.containsBean("tom");
        System.out.println("容器中Tom组件："+tom);  //false

        boolean user01 = run.containsBean("user01");
        System.out.println("容器中user01组件："+user01);

        boolean tom22 = run.containsBean("tom22");
        System.out.println("容器中tom22组件："+tom22);


        boolean haha = run.containsBean("haha");
        boolean hehe = run.containsBean("hehe");
        System.out.println("haha："+haha);
        System.out.println("hehe："+hehe);
    }
}
