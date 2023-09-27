# Spring全家桶笔记

## Spring/SpringBoot有关注解

> 其他注解，如MyBatis等在相关笔记中。

### @Bean

[大白话讲解Spring的@bean注解](https://zhuanlan.zhihu.com/p/99870991)

添加在配置类中返回对象的**方法**上。使得Spring框架自动调用此方法，并管理此方法返回的对象放入容器。

Spring的@Bean注解用于告诉**方法**，产生一个Bean对象，然后这个Bean对象交给Spring管理。 产生这个Bean对象的方法Spring只会调用一次，随后这个Spring将会将这个Bean对象放在自己的IOC容器中。@Bean明确地指示了一种方法，什么方法呢？产生一个bean的方法，并且交给Spring容器管理；从这我们就明白了为啥@Bean是放在方法的注释上了，因为它很明确地告诉被注释的方法，你给我产生一个Bean，然后交给Spring容器，剩下的你就别管了。记住，@Bean就放在方法上，就是让方法去产生一个Bean，然后交给Spring容器。

不知道大家有没有想过，用于注册Bean的注解的有那么多个，为何还要出现@Bean注解？

原因很简单：类似@Component , @Repository , @ Controller , @Service 这些注册Bean的注解存在局限性，只能局限作用于自己编写的类，如果是一个jar包第三方库要加入IOC容器的话，这些注解就手无缚鸡之力了，是的，@Bean注解就可以做到这一点！当然除了@Bean注解能做到还有@Import也能把第三方库中的类实例交给spring管理，而且@Import更加方便快捷，只是@Import注解并不在本篇范围内，这里就不再概述。

使用@Bean注解的另一个好处就是能够动态获取一个Bean对象，能够根据环境不同得到不同的Bean对象。

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

### @RestController：

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
- @Resource注解用在属性上、setter方法上。
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

### @SpringBootApplication

表明这是一个SpringBoot应用。@SpringBootApplication由三个注解组成`@SpringBootConfiguration`、`@EnableAutoConfiguration`、`@ComponentScan`。其中`@EnableAutoConfiguration`是开启SpringBoot的核心注解。

### @Scope

@Scope注解用于指定Bean的作用域

### 4个条件注解

* `@ConditionalOnClass`：如果类路径中存在这个类，则触发指定行为

* `@ConditionalOnMissingClass`：如果类路径中不存在这个类，则触发指定行为

* `@ConditionalOnBean`：如果容器中存在这个Bean（组件），则触发指定行为

* `@ConditionalOnMissingBean`：如果容器中不存在这个Bean（组件），则触发指定行为

### @ConfigurationProperties

[@ConfigurationProperties 注解使用姿势，这一篇就够了](https://zhuanlan.zhihu.com/p/75601572)

声明组件的属性和配置文件哪些前缀开始项进行绑定。

在编写项目代码时，我们要求更灵活的配置，更好的模块化整合。在 Spring Boot 项目中，为满足以上要求，我们将大量的参数配置在 application.properties 或 application.yml 文件中，通过 `@ConfigurationProperties` 注解，我们可以方便的获取这些参数值

### @EnableConfigurationProperties

快速注册注解。

> 场景：SpringBoot默认只扫描自己主程序所在的包。如果导入第三方包，即使组件上标注了 @Component、@ConfigurationProperties 注解，也没用。因为组件都扫描不进来，此时使用这个注解就可以快速进行**属性绑定**并把组件注册进容器

先说作用：

@EnableConfigurationProperties注解的作用是：**使使用 @ConfigurationProperties 注解的类生效。**

说明：

如果一个配置类只配置@ConfigurationProperties注解，而没有使用@Component，那么在IOC容器中是获取不到properties 配置文件转化的bean。说白了 @EnableConfigurationProperties 相当于把使用  @ConfigurationProperties 的类进行了一次注入。

### @EnableWebMvc

如果我们需要全面接管SpringMVC的所有配置并**禁用默认配置**，仅需要编写一个`WebMvcConfigurer`配置类，并标注 `@EnableWebMvc` 即可

### @SpringBootTest

Spring Test与JUnit等其他测试框架结合起来，提供了便捷高效的测试手段。而Spring Boot Test 是在Spring Test之上的再次封装，增加了切片测试，增强了mock能力。

整体上，Spring Boot Test支持的测试种类，大致可以分为如下三类：

- 单元测试：一般面向方法，编写一般业务代码时，测试成本较大。涉及到的注解有@Test。
- 切片测试：一般面向难于测试的边界功能，介于单元测试和功能测试之间。涉及到的注解有@RunWith @WebMvcTest等。
- 功能测试：一般面向某个完整的业务功能，同时也可以使用切面测试中的mock能力，推荐使用。涉及到的注解有@RunWith @SpringBootTest等。

### @Data

```
@Data = @NoArgsConstructor + @Getter + @Setter + @EqualsAndHashCode
注意：没有有参构造！！！！
```

> 只添加@Data注解时，查看class文件发现只有无参构造方法，添加@AllArgsConstructor和@NoArgsConstructor两个，才能同时有无参和带参构造方法

### @Mapper

在接口类上添加了@Mapper，在编译之后会生成相应的接口实现类。

使用 Mapper 接口的方式，不用写接口实现类，直接完成数据库操作，简单方便。

### @MapperScan

如果想要每个接口都要变成实现类，那么需要在每个接口类上加上@Mapper注解，比较麻烦，解决这个问题用@MapperScan。

@MapperScan用于扫描mapper接口所在的包。

**添加位置**：是在SpringBoot启动类上面添加。

### @EnableWebMvc

* 使用@EnableWebMvc注解启用spring mvc的基于java config的配置 

* 实现WebMvcConfigurer接口的方法可以自定义spring mvc的配置

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

@RequestParam是将请求参数和控制器方法的形参创建映射关系
@RequestParam注解一共有三个属性：

* value：指定为形参赋值的请求参数的参数名
* required：设置是否必须传输此请求参数，默认值为true
  若设置为true时，则当前请求必须传输value所指定的请求参数，若没有传输该请求参数，且没有设置defaultValue属性，则页面报错400：Required String parameter 'xxx' is not present；若设置为
  false，则当前请求不是必须传输value所指定的请求参数，若没有传输，则注解所标识的形参的值为
  null。
* defaultValue：不管required属性值为true或false，当value所指定的请求参数没有传输或传输的值
  为""时，则使用默认值为形参赋值

### @RequestHeader

@RequestHeader是将请求头信息和控制器方法的形参创建映射关系
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

@ExceptionHandler可以用来统一处理方法抛出的异常

## @ControllerAdvice

在Spring里，我们可以使用@ControllerAdvice来声明一些全局性的东西，最常见的是结合@ExceptionHandler注解用于全局异常的处理。

@ControllerAdvice是在类上声明的注解，其用法主要有三点：

- @ExceptionHandler注解标注的方法：用于捕获Controller中抛出的不同类型的异常，从而达到异常全局处理的目的；
- @InitBinder注解标注的方法：用于请求中注册自定义参数的解析，从而达到自定义请求参数格式的目的；
- @ModelAttribute注解标注的方法：表示此方法会在执行目标Controller方法之前执行 。

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