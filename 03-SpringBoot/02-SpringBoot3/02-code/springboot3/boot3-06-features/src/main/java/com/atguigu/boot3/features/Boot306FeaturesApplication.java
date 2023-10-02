package com.atguigu.boot3.features;

import com.atguigu.boot3.features.bean.Cat;
import com.atguigu.boot3.features.bean.Dog;
import com.atguigu.boot3.features.bean.Pig;
import com.atguigu.boot3.features.bean.Sheep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 环境隔离：
 * 1、标识环境
 *    1）、区分出几个环境： dev（开发环境）、test（测试环境）、prod（生产环境）
 *    2）、指定每个组件在哪个环境下生效； default环境：默认环境
 *          通过： @Profile({"test"})标注
 *          组件没有标注@Profile代表任意时候都生效
 *    3）、默认只有激活指定的环境，这些组件才会生效。
 * 2、激活环境
 *    配置文件激活：spring.profiles.active=dev；
 *    命令行激活： java -jar xxx.jar  --spring.profiles.active=dev
 *
 * 3、配置文件怎么使用Profile功能
 *    1）、application.properties： 主配置文件。任何情况下都生效——不能省略
 *    2）、其他Profile环境下命名规范：  application-{profile标识}.properties：
 *          比如：application-dev.properties
 *    3）、激活指定环境即可：  配置文件激活、命令行激活
 *    4）、效果：
 *        项目的所有生效配置项 = 激活环境配置文件的所有项 + 主配置文件和激活文件不冲突的所有项
 *        如果发生了配置冲突，以激活的环境配置文件为准。
 *        application-{profile标识}.properties 优先级高于 application.properties
 *
 *        主配置和激活的配置都生效，优先以激活的配置为准
 */
@SpringBootApplication   //主程序类
@Slf4j
public class Boot306FeaturesApplication {

    //1.SpringApplication:Boot应用的核心API入口
    public static void main(String[] args) {
        //写法1：
        //SpringApplication.run(Boot306FeaturesApplication.class, args);

        //写法2：拆成2步写，就可以自定义Spring应用了
        //SpringApplication application = new SpringApplication(Boot306FeaturesApplication.class);
        ////自定义配置：关掉banner
        ////程序化调整【SpringApplication的参数】
        ////不过：配置文件优先级高于程序化调整参数的优先级
        ////application.setBannerMode(Banner.Mode.OFF);
        //application.run(args);


        //写法3：Builder方式构建SpringApplication：通过FluentBuilder API进行设置
        ConfigurableApplicationContext context = new SpringApplicationBuilder()
                .main(Boot306FeaturesApplication.class)
                .sources(Boot306FeaturesApplication.class)
                .bannerMode(Banner.Mode.CONSOLE)
                //.environment(null)
                //.listeners(null)
                .properties("server.port=8888")
                .run(args);

        try {
            Cat cat = context.getBean(Cat.class);
            log.info("组件cat：{}",cat);
        }catch (Exception e){

        }

        try {
            Dog dog = context.getBean(Dog.class);
            log.info("组件dog：{}",dog);
        }catch (Exception e){

        }



        try {
            Pig pig = context.getBean(Pig.class);
            log.info("组件pig：{}",pig);
        }catch (Exception e){

        }

        try {
            Sheep sheep = context.getBean(Sheep.class);
            log.info("组件sheep：{}",sheep);
        }catch (Exception e){

        }
    }

}
