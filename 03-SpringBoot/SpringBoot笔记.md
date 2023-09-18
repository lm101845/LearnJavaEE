# SpringBoot笔记

## 注解

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

## 问题

> 我有一个问题，不是说autowired自动注入需要set方法的嘛，像构造方法这些的注入，并没有set方法，为什么也可以自动注入啊

在Spring框架中，Autowired注解确实可以用于自动装配bean，它默认是通过byType方式实现的，即Spring容器会查找和被注解的bean同类型的bean进行注入。Autowired注解可以作用在setter方法、构造方法以及属性上。

对于setter方法的注入，Spring会查找对应的setter方法，然后动态生成一个代理对象，通过调用setter方法将bean注入进去。

对于构造方法的注入，Spring会查找匹配的构造方法，然后通过构造一个新的对象实例，将所需的bean通过构造函数的参数注入进去。

对于属性注入，Spring会查找匹配的属性，然后将所需的bean直接赋值给该属性。

需要注意的是，当Autowired注解作用在构造方法上时，如果找不到匹配的bean，会抛出异常；而当Autowired注解作用在setter方法或属性上时，如果找不到匹配的bean，Spring会创建一个新的bean实例。