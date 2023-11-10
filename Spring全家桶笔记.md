# Spring全家桶笔记

## Spring/SpringBoot有关注解

### @Bean

[大白话讲解Spring的@bean注解](https://zhuanlan.zhihu.com/p/99870991)

添加在配置类中返回对象的**方法**上。使得Spring框架自动调用此方法，并管理此方法返回的**对象**放入容器。

Spring的@Bean注解用于告诉**方法**，**产生一个Bean对象**，然后这个Bean对象交给Spring管理。 产生这个Bean对象的方法Spring只会调用一次，随后这个Spring将会将这个Bean对象放在自己的IOC容器中。@Bean明确地指示了一种方法，什么方法呢？产生一个bean的方法，并且交给Spring容器管理；从这我们就明白了为啥@Bean是放在方法的注释上了，因为它很明确地告诉被注释的方法，你给我产生一个Bean，然后交给Spring容器，剩下的你就别管了。记住，@Bean就放在方法上，就是让方法去产生一个Bean，然后交给Spring容器。

不知道大家有没有想过，用于注册Bean的注解的有那么多个，为何还要出现@Bean注解？

原因很简单：类似@Component , @Repository , @ Controller , @Service 这些注册Bean的注解存在局限性，只能局限作用于自己编写的类，如果是一个jar包第三方库要加入IOC容器的话，这些注解就手无缚鸡之力了，是的，@Bean注解就可以做到这一点！当然除了@Bean注解能做到还有@Import也能把第三方库中的类实例交给spring管理，而且@Import更加方便快捷，只是@Import注解并不在本篇范围内，这里就不再概述。

使用@Bean注解的另一个好处就是能够动态获取一个Bean对象，能够根据环境不同得到不同的Bean对象。

=======================================================================================

在Java编程语言中，@Bean是一个注解，用于将一个方法标记为Spring容器中的一个Bean。 具体来说，@Bean注解可以用于方法上，该方法返回一个对象，该对象将被Spring容器管理和提供给其他程序组件使用。 @Bean注解通常与@Configuration注解一起使用，@Configuration注解用于标记一个Java类为Spring配置类，其中可以包含一些@Bean注解的方法，这些方法返回的对象将被Spring容器管理。 使用@Bean注解可以让开发人员更加方便地管理Spring容器中的对象，同时也可以利用Spring的依赖注入机制将这些对象注入到其他组件中。

### 多个URL处理注解(未列举完全)

[@GetMapping注解的理解](https://blog.csdn.net/qq_37924905/article/details/109137866)

Spring的复杂性不是来自于它处理的对象，而是来自于自身，不断演进发展的Spring会带来时间维度上复杂性，比如SpringMVC以前版本的**@RequestMapping**，到了新版本被下面新注释替代，相当于增加的选项：

@GetMapping
@PostMapping
@PutMapping
@DeleteMapping
@PatchMapping
从命名约定我们可以看到每个注释都是为了处理各自的传入请求方法类型，即@GetMapping用于处理请求方法的GET类型，@PostMapping用于处理请求方法的POST类型等。
如果我们想使用传统的**@RequestMapping**注释实现URL处理程序，那么它应该是这样的：

~~~java
@RequestMapping(value = “/get/{id}”, method = RequestMethod.GET)
~~~

新方法可以简化为：

~~~
@GetMapping("/get/{id}")
~~~

### @RequestMapping

用于将任意HTTP 请求映射到控制器方法上。

@RequestMapping表示共享映射，如果没有指定请求方式，将接收GET、POST、HEAD、OPTIONS、PUT、PATCH、DELETE、TRACE、CONNECT所有的HTTP请求方式。

@GetMapping、@PostMapping、@PutMapping、@DeleteMapping、@PatchMapping 都是HTTP方法特有的快捷方式@RequestMapping的变体，分别对应具体的HTTP请求方式的映射注解。

### @ResponseBody

> 原理：@ResponseBody由HttpMessageConverter处理

[被坑过后才知道学习HttpMessageConverter有多重要](https://juejin.cn/post/6886733763020062733)

在Java的Spring框架中，@ResponseBody是一个非常重要的注解。这个注解用于将Java对象转换为JSON或XML等格式，然后写入HTTP响应（response）。

具体来说，@ResponseBody注解可以应用在方法上或方法参数上。当应用在方法上时，Spring会将方法的返回值直接转化为JSON或XML等格式，然后写入HTTP响应。当应用在方法参数上时，Spring会将该参数转化为JSON或XML等格式，然后写入HTTP响应。

例如，如果我们有一个返回User对象的方法，我们可以使用@ResponseBody注解将其转化为JSON格式：


```java
@GetMapping("/user")
public @ResponseBody User getUser() {
    return new User("John", "Doe");
}
```
在这个例子中，Spring会将User对象转化为JSON格式，然后写入HTTP响应。

### @Controller

加在类上面的注解，使得类里面的每个方法都返回一个视图页面。

**在实际开发中，我们一般只是让后端的方法返回给前端是查询的数据，而不是一个新的视图页面。如果使用@Controller注解必须结合@ResponseBody，让这个方法返回给前端的不是一个视图，而只是给前端传递查询到的数据。**

### @RestController

~~~
@Controller + @ResponseBody = @RestController
~~~

**@RestController** ：从Spring 4.0以后产生的，用来将json/[xml](https://link.juejin.cn?target=https%3A%2F%2Fso.csdn.net%2Fso%2Fsearch%3Fq%3Dxml%26spm%3D1001.2101.3001.7020)数据发送到前台页面，而不是返回视图页面。它相当于@Controller和@ResponseBody。

**@RestController加在类上面的注解，使得类里面的每个方法都将json/xml返回数据加返回到前台页面中。所所以在实际开发中，我们一般都使用这个注解。**

### @Component

~~~
@Component(value = "user")等价于xml配置写法：
<bean id="user class="com.atguigu.spring6.bean.User"/>

（注：value可以不写，默认值就是User(首字母自动改成小写)）
~~~

### @Param

 @Param的作用就是给参数命名，比如在mapper里面某方法A（int id），当添加注解后A（@Param("userId") int id），也就是说外部想要取出传入的id值，只需要取它的参数名userId就可以了。将参数值传如SQL语句中，通过#{userId}进行取值给SQL的参数赋值。

### @Field

在 Spring Boot 中，@Field 注解是用来绑定请求参数到 Java 对象属性上的注解，它的原理是通过 Java 反射机制将 HTTP 请求中的参数值自动绑定到 Java 对象的属性上。当使用 @Field 注解时，Spring Boot 会根据注解中指定的属性名，在请求参数中查找同名的参数值，并将其自动转换为该属性的类型，然后赋值给该属性。

### 4个定义bean的注解

Spring 提供了以下多个注解，这些注解可以直接标注在 Java 类上，**将它们定义成 Spring Bean**。

| 注解        | 说明                                                         |
| ----------- | ------------------------------------------------------------ |
| @Component  | 该注解用于描述 Spring 中的 Bean，它是一个泛化的概念，仅仅表示容器中的一个组件（Bean），并且可以作用在应用的任何层次，例如 Service 层、Dao 层等。  使用时只需将该注解标注在相应类上即可。 |
| @Repository | 该注解用于将数据访问层（Dao 层）的类标识为 Spring 中的 Bean，其功能与 @Component 相同。 |
| @Service    | 该注解通常作用在业务层（Service 层），用于将业务层的类标识为 Spring 中的 Bean，其功能与 @Component 相同。 |
| @Controller | 该注解通常作用在控制层（如SpringMVC 的 Controller），用于将控制层的类标识为 Spring 中的 Bean，其功能与 @Component 相同。 |

### @Autowired

单独使用@Autowired注解，**默认根据类型装配**。【默认是byType】

源码：

~~~
package org.springframework.beans.factory.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowired {
    boolean required() default true;
}
~~~

源码中有两处需要注意：

- 第一处：该注解可以标注在哪里？
- - 构造方法上
  - 方法上
  - 形参上
  - 属性上
  - 注解上
- 第二处：该注解有一个required属性，默认值是true，表示在注入的时候要求被注入的Bean必须是存在的，如果不存在则报错。如果required属性设置为false，表示注入的Bean存在或者不存在都没关系，存在的话就注入，不存在的话，也不报错。

### @Resource

[@Resource注解](https://blog.csdn.net/weixin_38237873/article/details/83650429)

@Resource和@Autowired注解都是用来实现依赖注入的。只是@AutoWried按by type自动注入，而@Resource默认按byName自动注入。

>  @Resource与@Autowired注解区别：

@Resource注解也可以完成属性注入。那它和@Autowired注解有什么区别？

- @Resource注解是JDK扩展包中的，也就是说属于JDK的一部分。所以该注解是标准注解，更加具有通用性。(JSR-250标准中制定的注解类型。JSR是Java规范提案。)
- @Autowired注解是Spring框架自己的。
- **@Resource注解默认根据名称装配byName，未指定name时，使用属性名作为name。通过name找不到的话会自动启动通过类型byType装配。**
- **@Autowired注解默认根据类型装配byType，如果想根据名称装配，需要配合@Qualifier注解一起用。**
- @Resource注解用在**属性上、setter方法**上。
- @Autowired注解用在属性上、setter方法上、构造方法上、构造方法参数上。

@Resource注解属于JDK扩展包，所以不在JDK当中，需要额外引入以下依赖：【**如果是JDK8的话不需要额外引入依赖。高于JDK11或低于JDK8需要引入以下依赖。**】

~~~po
<dependency>
    <groupId>jakarta.annotation</groupId>
    <artifactId>jakarta.annotation-api</artifactId>
    <version>2.1.1</version>
</dependency>
~~~

### @Configuration

[@Configuration注解有什么用](https://blog.csdn.net/yldmkx/article/details/117780008)

[聊透spring @Configuration配置类](https://juejin.cn/post/7189145749618163768)

该注解的作用是：`用来定义当前类为配置类`。通常情况下。加了`@Configuration`的配置类内部，都会`包含一个或多个@Bean注解的方法`。

> 需要特别说明的是：`@Configuration`**继承**了`@Component`，这意味着@Configuration拥有@Component的全部功能，这也正是只加@Configuration，也能被Spring扫描并处理的原因。

### @ConfigurationProperties

[@ConfigurationProperties 注解使用姿势，这一篇就够了](https://zhuanlan.zhihu.com/p/75601572)

声明组件的属性和**配置文件(application.properties/yml)**哪些**前缀**开始项进行绑定。

在编写项目代码时，我们要求更灵活的配置，更好的模块化整合。在 Spring Boot 项目中，为满足以上要求，我们将大量的参数配置在 application.properties 或 application.yml 文件中，通过 `@ConfigurationProperties` 注解，我们可以方便的获取这些参数值

### @EnableConfigurationProperties

快速注册注解。

> 场景：SpringBoot默认只扫描自己主程序所在的包。如果导入第三方包，即使组件上标注了 @Component、@ConfigurationProperties 注解，也没用。因为组件都扫描不进来，此时使用这个注解就可以快速进行**属性绑定**并把组件注册进容器

先说作用：

@EnableConfigurationProperties注解的作用是：**使使用 @ConfigurationProperties 注解的类生效。**

说明：

如果一个配置类只配置@ConfigurationProperties注解，而没有使用@Component，那么在IOC容器中是获取不到properties 配置文件转化的bean。说白了 @EnableConfigurationProperties 相当于把使用  @ConfigurationProperties 的类进行了一次注入。

### @ContextConfiguration

`@ContextConfiguration`这个注解通常与`@RunWith(SpringJUnit4ClassRunner.class)`联合使用用来测试。

举例：

~~~
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
~~~

### @ComponentScan

自动扫描指定包下所有使用`@Service、@Component、@Controller、@Repository`的类并注册（类上）。

### @SpringJUnitConfig

举例：`@SpringJUnitConfig(locations = "classpath:bean.xml")`

等价写法：

~~~
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:bean.xml")
~~~

@SpringJUnitConfig注解是SpringBoot框架中的一个注解，用于单元测试。它可以用来加载应用程序上下文，并且可以使用该注释配置应用程序上下文。它可以代替通常使用的@RunWith(SpringRunner.class)和@SpringBootTest注释。

通过使用@SpringJUnitConfig，可以在单元测试期间方便地配置应用程序上下文，并且可以使用该注释配置应用程序上下文。

### @Transactional

 @Tranasctional注解是Spring 框架提供的声明式注解事务解决方案，我们在开发中使用事务保证方法对数据库操作的原子性，要么全部成功，要么全部失败，在使用@Transactional注解时需要注意以下问题:

* @Transactional  注解只能用在public 方法上，如果用在protected或者private的方法上，不会报错，但是该注解不会生效。
* @Transactional注解只能回滚非检查型异常，具体为RuntimeException及其子类和Error子类，可以从Spring源码的DefaultTransactionAttribute类里找到判断方法rollbackOn。
* 使用rollbackFor 属性来定义回滚的异常类型，使用 propagation 属性定义事务的传播行为。如:   回滚Exception类的异常，事务的传播行为支持当前事务，当前如果没有事务，那么会创建一个事务。
* @Transactional注解不能回滚被try{}catch() 捕获的异常。
* @Transactional注解只能对在被Spring 容器扫描到的类下的方法生效。

@Transactional标识在方法上，则只会影响该方法；@Transactional标识的类上，则会影响类中所有的方法

### @SpringBootApplication(复合注解)

表明这是一个SpringBoot应用。@SpringBootApplication由三个注解组成`@SpringBootConfiguration`、`@EnableAutoConfiguration`、`@ComponentScan`。其中`@EnableAutoConfiguration`是开启SpringBoot的核心注解。

~~~java
@SpringBootApplication = @SpringBootConfiguration + @EnableAutoConfiguration + @ComponentScan
~~~

#### @SpringBootConfiguration

就是`@Configuration`，容器中的组件，配置类。spring ioc启动就会加载创建这个类对象

#### @EnableAutoConfiguration(复合注解)

~~~
@EnableAutoConfiguration = @AutoConfigurationPackage + @Import
~~~

EnableAutoConfiguration自动装配的作用：即把指定的类构造成对象，并放入spring容器中，使其成为bean对象，作用类似@Bean注解。 
springboot启动的时候，会扫描该项目下所有`spring.factories`文件。

##### @AutoConfigurationPackage

- 扫描主程序包：加载自己的组件

- 利用 `@Import(AutoConfigurationPackages.Registrar.class)` 想要给容器中导入组件。
- 把主程序所在的**包**的所有组件导入进来。
- **为什么SpringBoot默认只扫描主程序所在的包及其子包**

##### @Import

* 加载所有自动配置类：加载starter导入的组件。

### @Filter

@Filter注解是Java中的一种注解，用于在Servlet容器中指定过滤器。过滤器是一种在请求到达目标资源之前或之后执行的处理程序，它可以对请求和响应进行修改、拦截或监视。

在Servlet 3.0及以上版本中，可以使用@Filter注解来声明和配置过滤器。通过在过滤器类上添加@Filter注解，并指定过滤器的相关属性，可以将过滤器注册到Servlet容器中。

### @Scope

@Scope注解用于指定Bean的作用域

### 4个条件注解

* `@ConditionalOnClass`：如果类路径中存在这个类，则触发指定行为

* `@ConditionalOnMissingClass`：如果类路径中不存在这个类，则触发指定行为

* `@ConditionalOnBean`：如果容器中存在这个Bean（组件），则触发指定行为

* `@ConditionalOnMissingBean`：如果容器中不存在这个Bean（组件），则触发指定行为

### @EnableWebMvc

* 全面接管SpringMVC，禁用掉所有MVC底层的自动配置。

如果我们需要**全面接管**SpringMVC的所有配置并**禁用默认配置**，仅需要编写一个`WebMvcConfigurer`配置类，并标注 `@EnableWebMvc` 即可

### @EnableAsync

开启异步

### @EnableScheduling

开启调度(定时任务)

### @SpringBootTest

Spring Test与JUnit等其他测试框架结合起来，提供了便捷高效的测试手段。而Spring Boot Test 是在Spring Test之上的再次封装，增加了切片测试，增强了mock能力。

整体上，Spring Boot Test支持的测试种类，大致可以分为如下三类：

- 单元测试：一般面向方法，编写一般业务代码时，测试成本较大。涉及到的注解有@Test。
- 切片测试：一般面向难于测试的边界功能，介于单元测试和功能测试之间。涉及到的注解有@RunWith @WebMvcTest等。
- 功能测试：一般面向某个完整的业务功能，同时也可以使用切面测试中的mock能力，推荐使用。涉及到的注解有@RunWith @SpringBootTest等。

### @Mapper

在接口类上添加了@Mapper，在编译之后会生成相应的接口实现类。

使用 Mapper 接口的方式，**不用写接口实现类，直接完成数据库操作**，简单方便。

### @MapperScan

如果想要每个接口都要变成实现类，那么需要在每个接口类上加上@Mapper注解，比较麻烦，解决这个问题用@MapperScan。

@MapperScan用于扫描mapper接口所在的包。

**添加位置**：是在SpringBoot启动类上面添加。

### @EnableWebMvc

* 使用@EnableWebMvc注解启用spring mvc的基于java config的配置 

* 实现WebMvcConfigurer接口的方法可以自定义spring mvc的配置

### @EnableDiscoveryClient

@EnableDiscoveryClient注解是把本服务的信息暴露给注册中心。

### @PathVariable

[@PathVariable注解的用法和作用（Demo详解）](https://blog.csdn.net/qq_43575801/article/details/128996889)

@PathVariable 映射 URL 绑定的占位符

通过 @PathVariable 可以**将 URL 中占位符参数**绑定到**控制器处理方法的入参**中。

URL 中的 {xxx} 占位符可以通过@PathVariable(“xxx”) 绑定到操作方法的入参中。

一般与@RequestMapping(method = RequestMethod.GET)一起使用

~~~java
@RequestMapping("/getUserById/{name}")
    public User getUser(@PathVariable("name") String name){
        return userService.selectUser(name);
    }
~~~

若方法参数名称和需要绑定的url中变量名称一致时,可以简写:

~~~java
@RequestMapping("/getUser/{name}")
    public User getUser(@PathVariable String name){
        return userService.selectUser(name);
    }
~~~

若方法参数名称和需要绑定的url中变量名称不一致时，写成:

~~~java
@RequestMapping("/getUserById/{name}")
    public User getUser(@PathVariable("name") String userName){
        return userService.selectUser(userName);
    }
~~~

### @RequestParam

@RequestParam是将**请求参数**和**控制器方法的形参**创建映射关系。

@RequestParam注解一共有三个属性：

* value：指定为形参赋值的请求参数的参数名

* required：设置是否必须传输此请求参数，默认值为true。

  若设置为true时，则当前请求必须传输value所指定的请求参数，若没有传输该请求参数，且没有设置defaultValue属性，则页面报错400：Required String parameter 'xxx' is not present；若设置为
  false，则当前请求不是必须传输value所指定的请求参数，若没有传输，则注解所标识的形参的值为
  null。

* defaultValue：不管required属性值为true或false，当value所指定的请求参数没有传输或传输的值
  为""时，则使用默认值为形参赋值

### @RequestHeader

@RequestHeader是将**请求头信息**和**控制器方法的形参**创建映射关系。

@RequestHeader注解一共有三个属性：value、required、defaultValue，用法同@RequestParam

### @CookieValue

@CookieValue是将cookie数据和控制器方法的形参创建映射关系
@CookieValue注解一共有三个属性：value、required、defaultValue，用法同@RequestParam

### @JacksonXmlRootElement 

Jackson是一个处理JSON的类库，不过它也通过jackson-dataformat-xml包提供了处理XML的功能。

引入支持写出xml内容依赖：

~~~xml
<dependency>
    <groupId>com.fasterxml.jackson.dataformat</groupId>
    <artifactId>jackson-dataformat-xml</artifactId>
</dependency>
~~~

@JacksonXmlRootElement注解有两个属性：

- namespace属性：用于指定XML根元素命名空间的名称。
- localname属性：用于指定XML根元素节点标签的名称。

### @ExceptionHandler

@ExceptionHandler可以用来统一处理方法抛出的异常。举例：

~~~java
/**
  * 处理不可控异常
  * @param e
  * @return
  */
@ExceptionHandler(Exception.class)
@ResponseBody  //为了能够返回数据
public R error(Exception e){
    e.printStackTrace();
    return R.error().message("执行了全局异常处理");
}
~~~

### @ControllerAdvice

在Spring里，我们可以使用@ControllerAdvice来声明一些**全局性的东西**，最常见的是结合@ExceptionHandler注解用于全局异常的处理。

@ControllerAdvice是在类上声明的注解，其用法主要有三点：

- @ExceptionHandler注解标注的方法：用于捕获Controller中抛出的不同类型的异常，从而达到异常全局处理的目的；
- @InitBinder注解标注的方法：用于请求中注册自定义参数的解析，从而达到自定义请求参数格式的目的；
- @ModelAttribute注解标注的方法：表示此方法会在执行目标Controller方法之前执行 。

### @RestControllerAdvice

@RestControllerAdvice是Spring框架中的一个注解，用于统一处理控制器异常和返回结果。它是@ControllerAdvice注解的特殊版本，用于处理RESTful风格的应用程序。

当控制器中抛出异常时，@RestControllerAdvice注解所标注的类将会被自动调用，并根据异常类型和处理程序的注解来决定如何处理该异常。类似地，当控制器返回数据时，@RestControllerAdvice注解所标注的类也将会被调用，根据返回数据的类型和处理程序的注解来决定如何处理该数据。

使用@RestControllerAdvice注解时，异常处理方法的返回值将自动转换为HTTP响应的主体。这意味着你可以在异常处理方法中定义全局的异常响应和返回结果处理程序，以保证在整个应用程序范围内统一处理异常和返回结果。

### @ImportResource

@ImportResource注解用于导入Spring的配置文件，让配置文件里面的内容生效；(就是以前写的springmvc.xml、applicationContext.xml)
Spring Boot里面没有Spring的配置文件，我们自己编写的配置文件，也不能自动识别；
想让Spring的配置文件生效，加载进来；@ImportResource标注在一个配置类上。
注意！这个注解是放在主入口函数的类上，而不是测试类上

不使用@ImportResource()注解，程序根本不能对我们spring的配置文件进行加载，所以我们需要将spring配置文件加载到容器里。

### @Profile

`@profile`注解的作用是指定类或方法在特定的 Profile 环境生效，任何`@Component`或`@Configuration`注解的类都可以使用`@Profile`注解。在使用DI来依赖注入的时候，能够根据`@profile`标明的环境，将注入符合当前运行环境的相应的bean。

### @PropertySource

@PropertySource注解用于指定资源文件读取的位置，它不仅能读取properties文件，也能读取xml文件，并且通过YAML解析器，配合自定义PropertySourceFactory实现解析YAML文件。

### @DisplayName

@DisplayName注解 用来提供个性化的名称，可以用于测试类与测试方法，用法大同小异。@DisplayName注解可以用来输出普通文字、特殊文字以及 emoji，能为测试提供更有意义的输出。

###  @BeforeAll

所有测试方法运行之前先运行这个 ： 只打印一次

###  @BeforeEach

每个测试方法运行之前先运行这个 ： 每个方法运行打印一次

###  @ParameterizedTest

**参数化测试**：同一个测试案例，改变的只是测试时候输入的参数不同。按照之前的做法，可能会是通过每个输入参数都写一个测试，或者将测试参数封装到集合中循环遍历执行测试。在新版的Junit5中，已经提供了一种更加优雅的方式来进行。

该特性允许我们：该特性可以让我们运行单个测试多次，且使得每次运行仅仅是参数不同而已。

### @ValueSource

将@ValueSource注解中的属性值赋予测试方法参数，执行测试方法。

### @MethodSource

指定方法名,返回值就是测试用的参数。

### @RunWith

**@RunWith(SpringRunner.class)和@SpringBootTest区别与联系**

@RunWith(SpringRunner.class)和@SpringBootTest都是Spring框架中用于单元测试的注解，但它们的用途和目标是不同的。

@RunWith(SpringRunner.class)是JUnit的一个注解，用于指定单元测试的运行器。在Spring框架中，这个注解使得测试能在Spring容器环境下执行。如果你需要在测试中使用Spring注入的类（例如，使用@Autowired注解的类），你就需要使用@RunWith(SpringRunner.class)注解，这样注入的类才能在Spring容器中实例化，使得自动注入能够生效。否则，如果你试图使用未注入的类，就可能会遇到NullPointerExecption。

@SpringBootTest是Spring Boot框架中的一个注解，它表示这个类是测试类。这个注解在打包程序时会被忽略，不会被打包发送。这个注解通常与@RunWith(SpringRunner.class)一起使用，以在Spring Boot环境中运行单元测试。

总结来说，这两个注解的联系在于它们通常一起使用，以在Spring Boot环境中进行单元测试。区别在于@RunWith(SpringRunner.class)是JUnit的注解，用于指定运行器，而@SpringBootTest是Spring Boot的注解，用于标识测试类。


### @EventListener

[SpringBoot中@EventListener注解的使用](https://blog.csdn.net/qq_37687594/article/details/113200974)

在开发工作中，会遇到一种场景，做完某一件事情以后，需要广播一些消息或者通知，告诉其他的模块进行一些事件处理，一般来说，可以一个一个发送请求去通知，但是有一种更好的方式，那就是事件监听，事件监听也是设计模式中 发布-订阅模式、观察者模式的一种实现。

观察者模式：简单的来讲就是你在做事情的时候身边有人在盯着你，当你做的某一件事情是旁边观察的人感兴趣的事情的时候，他会根据这个事情做一些其他的事，但是盯着你看的人必须要到你这里来登记，否则你无法通知到他（或者说他没有资格来盯着你做事情）。

对于 Spring 容器的一些事件，可以监听并且触发相应的方法。通常的方法有 2 种，ApplicationListener 接口和**@EventListener** 注解。

### @Order

注解@Order或者接口Ordered的作用是定义Spring IOC容器中Bean的执行顺序的优先级，而不是定义Bean的加载顺序，Bean的加载顺序不受@Order或Ordered接口的影响；

### @GetExchange

`@GetExchange` 注解是 Spring Framework 中的一个注解，用于指示一个方法应该处理 HTTP GET 请求，并且使用 Exchange 作为方法的参数类型。

在 Spring WebFlux 中，请求和响应的处理是基于非阻塞的，使用 `ServerWebExchange` 接口来表示当前的 HTTP 请求-响应交互。`@GetExchange` 注解是 Spring WebFlux 提供的注解，用于将处理方法与特定的 HTTP GET 请求路径关联起来，并将请求处理逻辑封装在方法中。

### @Cacheable

@Cacheable可以标记在一个方法上，也可以标记在一个类上。当标记在一个方法上时表示该方法是支持缓存的，当标记在一个类上时则表示该类所有的方法都是支持缓存的。对于一个支持缓存的方法，Spring会在其被调用后将其返回值缓存起来，以保证下次利用同样的参数来执行该方法时可以直接从缓存中获取结果，而不需要再次执行该方法。Spring在缓存方法的返回值时是以键值对进行缓存的，值就是方法的返回结果，至于键的话，Spring又支持两种策略，默认策略和自定义策略，这个稍后会进行说明。需要注意的是当一个支持缓存的方法在对象内部被调用时是不会触发缓存功能的。@Cacheable可以指定三个属性，value、key和condition。

### @JsonFormat

日期格式化注解,来源于`jackson`

### 切面注解

#### @Aspect

AOP为Aspect Oriented Programming的缩写，意为：面向切面编程，通过预编译方式和运行期动态代理实现程序功能的统一维护的一种技术.AOP是OOP的延续，是软件开发中的一个热点，也是Spring框架中的一个重要内容，是函数式编程的一种衍生范型。利用AOP可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间的耦合度降低，提高程序的可重用性，同时提高了开发的效率。

在spring AOP中业务逻辑仅仅只关注业务本身，将日志记录，性能统计，安全控制，事务处理，异常处理等代码从业务逻辑代码中划分出来，通过对这些行为的分离，我们希望可以将它们独立到非指导业务逻辑的方法中，进而改变这些行为的时候不影响业务逻辑的代码。

相关注解介绍：

~~~java
@Aspect:作用是把当前类标识为一个切面供容器读取
@Pointcut：Pointcut是植入Advice的触发条件。每个Pointcut的定义包括2部分，一是表达式，二是方法签名。方法签名必须是 public及void型。可以将Pointcut中的方法看作是一个被Advice引用的助记符，因为表达式不直观，因此我们可以通过方法签名的方式为 此表达式命名。因此Pointcut中的方法只需要方法签名，而不需要在方法体内编写实际代码。
@Around：环绕增强，相当于MethodInterceptor
@AfterReturning：后置增强，相当于AfterReturningAdvice，方法正常退出时执行
@Before：标识一个前置增强方法，相当于BeforeAdvice的功能，相似功能的还有
@AfterThrowing：异常抛出增强，相当于ThrowsAdvice
@After: final增强，不管是抛出异常或者正常退出都会执行
~~~

## MyBatis有关注解

#### @Select

@Select注解的目的是为了取代xml中的select标签，只作用于方法上面。

~~~mysql
 @Select("select * from employee where id = #{id}")
~~~

## Lombok有关注解

### @Data

```
@Data = @NoArgsConstructor + @Getter + @Setter + @EqualsAndHashCode
注意：没有有参构造！！！！
```

> 只添加@Data注解时，查看class文件发现只有无参构造方法，添加@AllArgsConstructor和@NoArgsConstructor两个，才能同时有无参和带参构造方法

### @Builder

> builder这个方法是lombook的一个注解，大概就是不用new 对象可以直接这样通过链式编程来构建对象，提高的了的代码的可读性和减少代码量。

Builder 使用创建者模式又叫建造者模式。简单来说，就是一步步创建一个对象，它对用户屏蔽了里面构建的细节，但却可以精细地控制对象的构造过程。

`@Builder`注释为你的类生成相对略微复杂的构建器API。`@Builder`可以让你以下面显示的那样调用你的代码，来初始化你的实例对象：

```java
Student.builder()
               .sno( "001" )
               .sname( "admin" )
               .sage( 18 )
               .sphone( "110" )
               .build();
```

`@Builder`可以放在类，构造函数或方法上。 虽然放在类上和放在构造函数上这两种模式是最常见的用例，但`@Builder`最容易用放在方法的用例来解释。

### @EqualsAndHashCode

这个注解的作用就是自动的给model bean实现equals方法和hashcode方法。

## Spring-Security有关注解

### @EnableWebSecurity

@EnableWebSecurity是Spring Security提供的注解，用于开启Web安全性支持。当该注解存在时，Spring Security的默认配置将会被应用。这个注解通常用于某个Web安全配置类上，实现接口WebSecurityConfigurer或者继承自WebSecurityConfigurerAdapter。继承了WebSecurityConfigurerAdapter的类，可以在子类中进行各种安全措施的配置。

### @EnableMethodSecurity

开启方法级别的精确权限控制。

`@EnableMethodSecurity`是Spring Security框架中的一个注解，用于开启方法级别的安全性配置。在Spring Security 5.6之后，它引入了一种更灵活的方法来配置方法安全授权（Method Security），替代了之前的标准做法`@EnableGlobalMethodSecurity`。

使用`@EnableMethodSecurity`注解，可以为应用中的方法配置身份认证和授权，以控制对方法的访问权限。该注解可以与Spring Security的其他功能结合使用，例如使用表达式实现更细粒度的访问控制。

在`@EnableMethodSecurity`注解中，可以使用一些属性来进一步配置方法安全授权。例如，`securedEnabled`属性用于开启`@Secured`注解过滤权限的功能，`jsr250Enabled`属性用于开启`@RolesAllowed`注解过滤权限的功能，而`prePostEnabled`属性则使得表达式时间方法级别的安全性4个注解可用，包括`@PreAuthorize`、`@PostAuthorize`等。

总的来说，`@EnableMethodSecurity`注解为Spring应用提供了一种灵活且强大的方法安全授权机制，帮助开发者更好地控制对应用方法的访问权限。

### @PreAuthorize

@PreAuthorize注解会在方法执行前进行权限验证，支持Spring EL表达式，它是基于方法注解的权限解决方案。只有当@EnableGlobalMethodSecurity(prePostEnabled=true)的时候，@PreAuthorize才可以使用，@EnableGlobalMethodSecurity注解在SPRING安全中心进行设置。

## Swagger有关注解

| 注解         | 标注位置            | 作用                   |
| ------------ | ------------------- | ---------------------- |
| @Tag         | controller 类       | 标识 controller 作用   |
| @Parameter   | 参数                | 标识参数作用           |
| @Parameters  | 参数                | 参数多重说明           |
| @Schema      | model 层的 JavaBean | 描述模型作用及每个属性 |
| @Operation   | 方法                | 描述方法作用           |
| @ApiResponse | 方法                | 描述响应状态码等       |

## RabbitMQ有关注解

### @RabbitListener

@RabbitListener是Spring AMQP中的一个注解，它用于声明一个方法是RabbitMQ消息监听器，用于接收指定队列中的消息。当使用@RabbitListener注解的方法上，可以接收来自RabbitMQ队列的消息。同时，这个方法可以通过使用@RabbitHandler注解标记，并在方法中声明一个参数来表示要接收的消息。

在具体作用上，@RabbitListener会自动创建和配置一个RabbitMQ连接工厂，并绑定到指定的队列。它也会自动创建和配置一个RabbitMQ消费者，并在消息到达时调用带有@RabbitHandler注解的方法处理消息。此外，它还允许通过一些配置参数来定制RabbitMQ连接工厂和消费者的行为，例如设置消息的自动确认模式、设置并发消费者数、设置消息转换器等。

总的来说，@RabbitListener为Spring应用程序提供了一种方便的方式来处理RabbitMQ队列中的消息。

~~~java
@Component
public class SpringRabbitListener {
    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueue(String msg){
        System.out.println("spring 消费者接收到消息：【" + msg + "】");
    }
}
~~~

### @Queue

@Queue是Spring AMQP中的一个注解，用于配置RabbitMQ的队列。它主要用于声明队列的属性，例如队列名称、是否持久化、是否自动删除以及是否独占等。具体来说，@Queue注解有以下属性：

* value：指定队列的名称。
* durable：指定队列是否持久化。如果为true，则队列将在RabbitMQ服务器重启后仍然存在。默认为false。
* exclusive：指定队列是否为当前连接的独占队列。如果为true，则该队列只能被当前连接使用，其他连接无法访问。默认为false。
* autoDelete：指定队列是否自动删除。如果为true，则当最后一个消费者断开连接后，队列将被自动删除。默认为false。

需要注意的是，在Spring Boot中使用RabbitMQ时，创建队列的方式与之前的RabbitMQ使用方式有所不同。在Spring Boot中，队列是根据消费者来创建的，只有存在消费者时才会创建队列。而在之前的RabbitMQ使用方式中，运行生产者就会直接创建队列。因此，在使用Spring Boot和RabbitMQ时，需要在消费者中使用@Queue注解来声明队列，以确保队列能够正确地创建和配置。

### @QueueBinding

@QueueBinding是Spring AMQP中的一个注解，用于配置RabbitMQ的队列和交换器的绑定关系。它主要用于指定队列、交换器和路由键的信息，以便将队列和交换器正确地绑定在一起。具体来说，@QueueBinding注解有以下属性：

* value：指定绑定的队列，使用@Queue注解的value属性来指定队列的名称。
* exchange：指定绑定的交换器，使用@Exchange注解的value属性来指定交换器的名称。
* key：指定路由键，用于将消息从交换器路由到队列。

需要注意的是，在使用@QueueBinding注解时，必须同时指定@Queue和@Exchange注解，以便正确配置队列和交换器的绑定关系。同时，路由键也需要根据实际情况进行配置，以便将消息正确地路由到指定的队列中。

### @Exchange

@Exchange是Spring AMQP中的一个注解，用于配置RabbitMQ的交换器。它主要用于声明交换器的名称、类型和属性，以便将消息从生产者发送到队列中。具体来说，@Exchange注解有以下属性：

* value：指定交换器的名称。
* type：指定交换器的类型，包括direct、fanout、topic和headers四种类型。
* durable：指定交换器是否持久化。如果为true，则交换器将在RabbitMQ服务器重启后仍然存在。默认为false。
* autoDelete：指定交换器是否自动删除。如果为true，则当没有任何队列与其绑定时，交换器将被自动删除。默认为false。

需要注意的是，交换器的类型决定了消息从生产者发送到队列的方式，不同的类型有不同的路由规则。例如，direct类型使用精确匹配的路由键将消息路由到队列，fanout类型将消息发送到所有与其绑定的队列，topic类型使用模式匹配的路由键将消息路由到队列，而headers类型则使用消息头的匹配规则将消息路由到队列。因此，在选择交换器类型时，需要根据实际的需求进行配置。

## 方法

### getBean

[Spring——ApplicationContext之getBean方法详解](https://blog.csdn.net/weixin_43949634/article/details/113963411)

## 问题

> 我有一个问题，不是说autowired自动注入需要set方法的嘛，像构造方法这些的注入，并没有set方法，为什么也可以自动注入啊

在Spring框架中，Autowired注解确实可以用于自动装配bean，它默认是通过byType方式实现的，即Spring容器会查找和被注解的bean同类型的bean进行注入。Autowired注解可以作用在setter方法、构造方法以及属性上。

对于setter方法的注入，Spring会查找对应的setter方法，然后动态生成一个代理对象，通过调用setter方法将bean注入进去。

对于构造方法的注入，Spring会查找匹配的构造方法，然后通过构造一个新的对象实例，将所需的bean通过构造函数的参数注入进去。

对于属性注入，Spring会查找匹配的属性，然后将所需的bean直接赋值给该属性。

需要注意的是，当Autowired注解作用在构造方法上时，如果找不到匹配的bean，会抛出异常；而当Autowired注解作用在setter方法或属性上时，如果找不到匹配的bean，Spring会创建一个新的bean实例。

## 小贴士

* IOC容器中，只能存在类对应的bean，而不能存在接口对应的bean
* 有了MyBatis-Plus以后，绝大多数情况下就不用我们自己去写SQL语句了，它给我们提供了模板mapper，我们调用模板Mapper即可。

## 博文

### VO(后端传给前端)、DTO(前端传给后端)、DO、POJO、PO的区别和概念

* 概念：
  * **VO**（View Object）：**视图对象**，用于页面展示层，它的作用是把某个指定页面（或组件）的数据封装起来，**传输到前端页面**上。
  * **DTO**（Data Transfer Object）：**数据传输对象**，通常作为方法入参来使用。在此仅泛指用于**展示层**（如Controller）与**服务层**（如service/Impl）之间的数据传输对象。对其J2EE设计模式内的作用不做深入探讨。
    * 当前端提交的数据和实体类中对应的属性差别较大时，建议使用DTO来封装数据。
  * **DO**（Domain Object）：**领域对象**（或称实体对象），就是从现实世界中抽象出来的有形或无形的业务实体。
  * **POJO**（Plain Ordinary Java Object）：简单的Java对象，实际就是**普通JavaBeans**，是为了避免和EJB混淆所创造的简称，它不包含业务逻辑或持久逻辑等。POJO对象有时也被称为Data对象，大量应用于表现现实中的对象。**一个POJO持久化以后就是PO**。
  * **PO**（Persistent Object）：**持久化对象**，通常与持久层（DAO，通常是关系型数据库）的数据结构形成一一对应的映射关系。

* 区别：

  * 这几个概念所应用的场景不同，在三层架构中各自的位置有所不同：

  前端发起请求或提交表单，请求中或表单里的数据传输到后端，在展示层被匹配为VO。展示层把VO转换为服务层对应方法所需要的DTO，传送给服务层。服务层根据DTO的数据构造或重建一个DO，然后再调用DO的业务方法来完成具体的业务。然后服务层再把DO转换为持久层对应的PO，调用持久层的持久化方法，把PO传递给它，完成持久化操作。

  * **VO与DTO的区别**：DTO代表服务层需要接收的数据和返回的数据，而VO代表**展示层需要显示的数据**。
  * **DTO与DO的区别**：首先是概念上的区别，DTO是展示层和服务层之间的数据传输对象，而DO是对现实世界各种业务角色的抽象，这就引出了两者在数据上的区别。例如：UserInfo（DO）和User（DTO），对于一个getUser()方法来说，本质上它永远不应该返回用户的密码，因此UserInfo至少比User少一个password的字段。而在领域驱动设计中，正如上文描述DO不是简单的POJO，重点在于领域业务逻辑。
  * **DO与PO的区别**：DO和PO在绝大部分情况下是一一对应的，**PO是只含有get/set方法的POJO**，但某些场景还是能反映出两者在概念上存在本质的区别，PO是需要**持久化**的，与**数据库**息息相关，而DO是**业务**上的，具有**业务逻辑**。

### entity包、model包、domain包的区别

[entity包、model包、domain包的区别](https://blog.csdn.net/qq_38977097/article/details/81702349)

#### entity(实体)

entity的意思就是实体的意思，所以也是最常用到的，entity包中的类是必须和数据库相对应的，比如说：数据库有个user表，字段有long类型的id，string类型的姓名，那么entity中的user类也必须是含有这两个字段的，且类型必须一致。不能数据库存的是long类型，user类里的属性是string类型。这样做的好处是保持实体类和数据库保持一致，另外，当用到hibernate或是mybatie框架来操作数据库的时候，操作这个实体类就行，写sql文之前不需要再做数据格式处理。

#### model(模型)

model大家不陌生，都知道是模型的意思，当用model当包名的时候，一般里面存的是实体类的模型，一般是用来给前端用的。比如：前端页面需要显示一个user信息，user包含姓名，性别，居住地，这些信息存在数据库的时候，姓名直接存姓名，但是性别和居住地一般会用数据字典的编号存到数据库，比如：111代表男，222代表女，数据库存的就是111或222，如果用entity的话，把111、222前端都不知道是什么玩意，就算前端知道111代表男，222代表女，写了一个js判断数据处理。后来数据库变动了，111代表女，222代表男，前端的js又需要重新写，很显然这样不利于维护。所以就需要model来解决，后台从数据库取了数据转化为前端需要的数据直接传给前端，前端就不需要对数据来处理，直接显示就行了。还有一种情况，数据库里面的user表字段有十个，包含姓名，qq，生辰八字乱七八糟的等，但是前台页面只需要显示姓名，如果把entity全部传给前台，无疑传了很多没用的数据。这时候model就很好的解决了这个问题，前台需要什么数据，model就包含什么数据就行了

#### domain(域)

domain这个包国外很多项目经常用到，字面意思是域的意思。范围有点广了，比如一个商城的项目，商城主要的模块就是用户，订单，商品三大模块，那么这三块数据就可以叫做三个域，domain包里就是存的就是这些数据，表面上这个包和entity和model包里存的数据没什么区别，其实差别还是挺大的，特别是一些大型的项目。比如一个招聘网站的项目，最重要的对象就是简历了，那么简历是怎么存到数据库的呢，不可能用一张表就能存的，因为简历包含基本信息和工作经验，项目经验，学习经验等。基本信息可以存在简历表，但是涉及到多条的就不行，因为没人知道有多少条工作经验，项目经验，所以必须要单独建工作经验表和项目经验表关联到简历基本信息表。但是前台页面是不关心这些的，前台需要的数据就是一个简历所有信息，这时就可以用到domain来处理，domain里面的类就是一个简历对象，包含了简历基本信息以及list的工作经验，项目经验等。这样前端只需要获取一个对象就行了，不需要同时即要获取基本信息，还要从基本信息里面获取工作经验关联的简历编号，然后再去获取对应的工作经验了。
当然，如果用model的话也是可以达到domain的效果的。这个完全是看个人喜好和项目的整体架构，因为创建不同的package的作用本来也就是想把项目分成不同的层，便于管理和维护。如果你乐意，你可以创建entity包，然后在里面存图片，创建images文件夹，里面存js。你已经看懂就行，前提是如果是团队开发的话能保证别人不打你。这个和语言一个道理，你在200面前和英国人说：private void set(int age),人家说：滚犊子；现在你这样说，人家就知道是java语言了。能被人们通用的才叫语言，你说的别人听不懂那只能算是鸟语。所以开发的时候，建类建包的命名规则规范性还是很重要的。

#### 总结

那么三句话总结下entity、model、domain的不同：

- entity字段必须和数据库字段一样
- model前端需要什么我们就给什么
- domain很少用，代表一个对象模块

### 架构分析

实体类这一层，有的开发写成pojo，有的写成model，也有domain，也有dto（这里做参数验证，比如password不能为空等），实体类如果你不懂什么东西的话，那你就想成是范围。

mapper 是Mybatis 操作数据库的那一层，就是dao层。

service包含了serviceImpl（service接口的实现类） 是提供给controller 使用的，针对于某些业务将 dao 的对于某些表的crud进行组合，也就是说间接的和数据库打交道。

controller 通过调用service来完成业务逻辑。

### SpringBoot中mapper.xml文件存放的两种位置

[SpringBoot中mapper.xml文件存放的两种位置](https://blog.csdn.net/nulinuligengnuli/article/details/119353021)

### Lombok 中的 @Slf4j 注解和 @Data 注解

[Lombok 中的 @Slf4j 注解和 @Data 注解](https://www.cnblogs.com/ban-boi-making-dinner/p/17217842.html)

### org.junit.test 和 org.junit.jupiter.api.test区别

org.junit.Test 和 org.junit.jupiter.api.Test 都是 JUnit 中的注解，用于标识测试方法，但它们来自 JUnit 的不同版本，具有一些不同的特性和用法。

1. JUnit 版本：org.junit.Test 是 JUnit 4 的注解，而 org.junit.jupiter.api.Test 是 JUnit 5 的注解。
2. 注解特性：在 JUnit 4 中，@Test 注解可以用于任何公共的 void 方法，且不需要额外的修饰符。但在 JUnit 5 中，如果使用 org.junit.jupiter.api.Test 注解，测试方法必须是 public 的，否则将会抛出异常。
3. 异常处理：在 JUnit 4 中，如果一个测试方法抛出了任何异常，JUnit 会将其报告为失败。而在 JUnit 5 中，异常处理更加精细，你可以使用 assertThrows 方法来捕获并检查预期的异常。
4. 拓展性：JUnit 5 提供了更多的特性，如动态测试、嵌套测试、条件测试等，这使得测试更加灵活和强大。
5. 在 Spring Boot 中的使用：在 Spring Boot 2.2.x 之前，通常使用 JUnit 4，即 org.junit.Test 注解。在 Spring Boot 2.2.x 及之后的版本中，推荐使用 JUnit 5，即 org.junit.jupiter.api.Test 注解。

总结来说，org.junit.Test 和 org.junit.jupiter.api.Test 都用于标识测试方法，但后者提供了更多的特性和灵活性，且在 Spring Boot 的新版本中推荐使用。

### 只引用spring-boot-starter-web不引用spring-boot-starter可以吗

只要我们在 Spring  Boot 项目中的 pom.xml 中引入了 spring-boot-starter-web ，即使不进行任何配置，也可以直接使用 Spring MVC 进行 Web 开发。

### spring boot的pom.xml中，什么时候应该写version，什么时候不写

在Spring Boot项目的`pom.xml`文件中，`version`元素是用来指定项目依赖的版本号的。在大部分情况下，你应该为项目依赖指定一个具体的版本号。这样可以确保你的项目在构建和运行时使用的是你预期的特定版本。

然而，在Spring Boot项目中，有一种特殊情况可以不指定依赖的版本号，那就是当你使用Spring Boot的"父POM"时。Spring Boot提供了一个包含常用依赖管理的父POM，你可以在你的`pom.xml`文件中继承它。当你继承Spring Boot的父POM时，它可以为你管理依赖的版本，因此你不需要在每个依赖中都指定版本号。

下面是一个继承Spring Boot父POM的示例：


```xml
<project>
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>my-spring-boot-project</artifactId>
    <version>1.0.0</version>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.5.4</version> <!-- 指定Spring Boot的版本 -->
    </parent>

    <properties>
        <java.version>1.8</java.version> <!-- 指定Java版本 -->
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId> <!-- 不需要指定版本号 -->
        </dependency>
        <!-- 其他依赖 -->
    </dependencies>

    <!-- 其他配置 -->
</project>
```
在这个示例中，我们继承了`spring-boot-starter-parent`作为父POM，并指定了它的版本号`2.5.4`。在`<dependencies>`中，我们添加了`spring-boot-starter-web`依赖，但是没有指定版本号。这是因为父POM已经为我们管理了版本的依赖关系。

总结起来，当你使用Spring Boot的父POM时，你可以省略依赖的版本号。但是，如果你没有使用父POM或者需要覆盖父POM中指定的版本号，你应该在`<dependencies>`中指定具体的版本号。

### **spring boot3可以使用swagger2吗？**

Spring Boot 3目前(2023年10月4日15:48:34)还不支持Swagger 2。Swagger 2是针对Spring Boot 1.x和2.x版本的，而Spring Boot 3在架构和依赖项方面有很大的变化，因此Swagger 2无法直接在Spring Boot 3上使用。

不过，Spring Boot 3支持OpenAPI 3.0规范，这是Swagger的后续版本。OpenAPI 3.0提供了更强大的功能和更好的规范，因此在Spring Boot 3中建议使用OpenAPI 3.0代替Swagger 2。

为了在Spring Boot 3中使用OpenAPI 3.0，你可以使用SpringDoc项目。SpringDoc是一个基于OpenAPI 3.0规范的Spring Boot扩展，它可以自动生成API文档并提供强大的UI界面。

要开始使用SpringDoc，请在Spring Boot 3项目中添加以下依赖项：

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>最新的版本号</version>
</dependency>
```

然后，在应用程序的配置文件中添加以下属性：

```properties
springdoc.api-docs.enabled=true
springdoc.swagger-ui.enabled=true
```

现在，你可以通过访问`/swagger-ui/index.html`来查看自动生成的API文档。

请注意，SpringDoc在Spring Boot 3中的用法可能与在较早版本中的用法有所不同。因此，请查阅SpringDoc的官方文档以获取更详细的信息和最新的用法示例。

### **swagger和knife4j区别**

Swagger和Knife4j都是用于生成、描述、调用和可视化RESTful风格的Web服务（API文档）的工具，但它们在功能和用法上有一些区别。

1. Swagger是一个规范和完整的框架，主要用于生成API文档。它使得前后端分离开发更加方便，有利于团队协作。Swagger可以自动生成接口文档，降低后端开发人员编写接口文档的负担。此外，Swagger还提供了功能测试的功能。
2. Knife4j是Swagger的增强UI实现，为Java开发者在使用Swagger的时候，提供了简洁、强大的接口文档体验。它在完全遵循了Swagger的使用方式的基础上，做了功能增强。如果你用过Swagger，你可以无缝切换到Knife4j。

总的来说，Swagger和Knife4j都是为了更好地管理和展示API文档而开发的工具，它们可以帮助开发人员提高开发效率，促进团队协作。具体选择哪个工具，可以根据项目的需求和团队的偏好来决定。

> 我项目中引入了支持SpringBoot3版的knife4j，但是还不熟悉怎么用，暂时是只用到了swagger

### pom.xml中为什么要exclude lombok

在你提供的 Maven 配置中，`lombok` 被排除在 `spring-boot-maven-plugin` 之外。`lombok` 是一个 Java 库，它通过注解减少了 Java 代码的样板代码。例如，你可以使用 `@Getter` 和 `@Setter` 注解自动创建 getter 和 setter 方法，而不是手动编写这些方法。

将 `lombok` 排除在 `spring-boot-maven-plugin` 之外可能有以下几个原因：

1. **避免依赖冲突**：如果你的项目中有多个版本的 `lombok`，可能会导致依赖冲突。通过排除 `lombok`，你可以确保 `spring-boot-maven-plugin` 不会使用任何版本的 `lombok`，从而避免潜在的冲突。
2. **减少插件的复杂性**：`spring-boot-maven-plugin` 可能会处理一些与 `lombok` 相关的复杂情况，例如处理生成的代码或其他与 `lombok` 相关的特性。通过排除 `lombok`，你可以简化插件的配置和处理。
3. **自定义 `lombok` 版本**：你的项目可能需要特定版本的 `lombok`，而 `spring-boot-maven-plugin` 可能会默认使用不同版本。通过排除 `lombok`，你可以确保插件不会使用其默认版本，而是使用你在项目其他地方定义的版本。
4. **避免不必要的依赖**：`spring-boot-maven-plugin` 可能不需要 `lombok` 来执行其任务。通过排除它，你可以避免引入不必要的依赖，从而减小项目的规模和复杂性。

通常，在 Maven 项目中排除依赖是为了解决特定的问题或满足特定的需求。具体的原因可能取决于你的项目配置和需求。

### gson,jackson,fastjson区别

Gson、Jackson 和 FastJson 都是用于在 Java 对象和 JSON 数据之间进行映射的库。以下是它们之间的主要区别：

1. 性能：虽然性能并不是唯一需要考虑的因素，但相对于数据库 IO，JSON 解析时间可以忽略不计。FastJson 针对特定需求做了很多优化，因此在某些情况下，FastJson 的性能可能优于 Gson 和 Jackson。
2. 功能和可配置性：Jackson 的功能更强大，可配置化程度更高。例如，它可以序列化 Guava 类型、Java 8 中的时间日期等。Gson 和 FastJson 也提供了许多配置选项，但在某些复杂情况下，Jackson 可能更灵活。
3. 严格性：FastJson 针对特定需求做了优化，导致校验不严格。例如，数组 []、夏令时、末尾不带逗号等都能转成对象。这可能在某些情况下会导致数据不一致或其他问题。Gson 和 Jackson 在这方面相对更严格。
4. 起源和发展：Gson 是 Google 提供的库，最初是为在 Google 内部使用而创建的，后来进行了开源。Jackson 和 FastJson 则是由社区开发者创建的开源项目。

综上所述，Gson、Jackson 和 FastJson 各有优势。在选择时，需要根据项目的具体需求和目标来决定使用哪个库。