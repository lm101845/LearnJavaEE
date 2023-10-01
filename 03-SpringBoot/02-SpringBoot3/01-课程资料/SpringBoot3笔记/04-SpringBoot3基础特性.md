# 04-SpringBoot3基础特性

## SpringApplication

### 自定义 banner

* 类路径添加banner.txt或设置spring.banner.location就可以定制 banner

* 推荐网站：[Spring Boot banner 在线生成工具，制作下载英文 banner.txt，修改替换 banner.txt 文字实现自定义，个性化启动 banner-bootschool.net](https://www.bootschool.net/ascii)

### 自定义 SpringApplication

~~~java
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(MyApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
~~~

###  FluentBuilder API

~~~java
new SpringApplicationBuilder()
    .sources(Parent.class)
    .child(Application.class)
    .bannerMode(Banner.Mode.OFF)
    .run(args);
~~~

## Profiles

环境隔离能力；快速切换开发、测试、生产环境

步骤：

* **标识环境**：指定哪些**组件**、**配置**在哪个环境生效

* **切换环境**：这个环境对应的所有组件和配置就应该生效

### 使用

#### 指定环境

- Spring Profiles 提供一种**隔离配置**的方式，使其仅在**特定环境**生效；
- 任何`@Component`,` @Configuration` 或 `@ConfigurationProperties` 可以使用 @Profile 标记，来指定何时被加载。【**容器中的组件**都可以被 `@Profile`标记】

#### 环境激活

* 配置激活指定环境； 配置文件

  ~~~java
  spring.profiles.active=production,hsqldb
  ~~~

* 也可以使用命令行激活。--spring.profiles.active=dev,hsqldb

* 还可以配置**默认环境**； **不标注@Profile 的组件永远都存在**。

1. * 以前默认环境叫default

2. * `spring.profiles.default=test`

* 推荐使用激活方式激活指定环境

#### 环境包含

注意：

* `spring.profiles.active`和`spring.profiles.default`只能用到 **无 profile 的文件**中，如果在`application-dev.yaml`中编写就是**无效的**

* 也可以额外添加生效文件，而不是激活替换。比如：

~~~xml
spring.profiles.include[0]=common
spring.profiles.include[1]=local
~~~

最佳实战：

- **生效的环境** = **激活的环境/默认环境**  + **包含的环境**
- 项目里面这么用

- - 基础的配置`mybatis`、`log`、`xxx`：写到**包含环境中**
  - 需要动态切换变化的 `db`、`redis`：写到**激活的环境中**

####  Profile 分组

创建prod组，指定包含db和mq配置

~~~xml
spring.profiles.group.prod[0]=db
spring.profiles.group.prod[1]=mq
~~~

使用`--spring.profiles.active=prod` ，就会激活prod，db，mq配置文件

#### Profile 配置文件

- `application-{profile}.properties`可以作为**指定环境的配置文件**。
- 激活这个环境，**配置**就会生效。最终生效的所有**配置**是

- - `application.properties`：主配置文件，任意时候都生效
  - `application-{profile}.properties`：指定环境配置文件，激活指定环境生效

profile优先级 > application 