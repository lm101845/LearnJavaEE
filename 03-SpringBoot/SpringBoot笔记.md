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