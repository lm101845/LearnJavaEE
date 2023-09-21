# Spring及SpringBoot笔记

## 注解

### @Bean

[大白话讲解Spring的@bean注解](https://zhuanlan.zhihu.com/p/99870991)

添加在配置类中返回对象的**方法**上。使得Spring框架自动调用此方法，并管理此方法返回的对象放入容器。

Spring的@Bean注解用于告诉**方法**，产生一个Bean对象，然后这个Bean对象交给Spring管理。 产生这个Bean对象的方法Spring只会调用一次，随后这个Spring将会将这个Bean对象放在自己的IOC容器中。@Bean明确地指示了一种方法，什么方法呢？产生一个bean的方法，并且交给Spring容器管理；从这我们就明白了为啥@Bean是放在方法的注释上了，因为它很明确地告诉被注释的方法，你给我产生一个Bean，然后交给Spring容器，剩下的你就别管了。记住，@Bean就放在方法上，就是让方法去产生一个Bean，然后交给Spring容器。

不知道大家有没有想过，用于注册Bean的注解的有那么多个，为何还要出现@Bean注解？

原因很简单：类似@Component , @Repository , @ Controller , @Service 这些注册Bean的注解存在局限性，只能局限作用于自己编写的类，如果是一个jar包第三方库要加入IOC容器的话，这些注解就手无缚鸡之力了，是的，@Bean注解就可以做到这一点！当然除了@Bean注解能做到还有@Import也能把第三方库中的类实例交给spring管理，而且@Import更加方便快捷，只是@Import注解并不在本篇范围内，这里就不再概述。

使用@Bean注解的另一个好处就是能够动态获取一个Bean对象，能够根据环境不同得到不同的Bean对象。

### @GetMapping等URL处理注解

[@GetMapping注解的理解](https://blog.csdn.net/qq_37924905/article/details/109137866)

Spring的复杂性不是来自于它处理的对象，而是来自于自身，不断演进发展的Spring会带来时间维度上复杂性，比如SpringMVC以前版本的**@RequestMapping**，到了新版本被下面新注释替代，相当于增加的选项：

@GetMapping
@PostMapping
@PutMapping
@DeleteMapping
@PatchMapping
从命名约定我们可以看到每个注释都是为了处理各自的传入请求方法类型，即@GetMapping用于处理请求方法的GET类型，@PostMapping用于处理请求方法的POST类型等。
如果我们想使用传统的*@RequestMapping*注释实现URL处理程序，那么它应该是这样的：

~~~java
@RequestMapping(value = “/get/{id}”, method = RequestMethod.GET)
~~~

新方法可以简化为：

~~~
@GetMapping("/get/{id}")
~~~

### @ResponseBody

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

### 使用注解定义bean

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

> 需要特别说明的是：`@Configuration继承了@Component`，这意味着@Configuration拥有@Component的全部功能，这也正是只加@Configuration，也能被Spring扫描并处理的原因。

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