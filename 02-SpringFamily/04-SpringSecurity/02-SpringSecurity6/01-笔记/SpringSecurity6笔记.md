# SpringSecurity6笔记

> https://www.yuque.com/chengxuyuanyideng/prp17u/oa6ekik6sntmmgxk
>
> 2023年9月28日14:29:36
>
> 权限框架本质上就是过滤器，如果学SpringSecurity吃力，就回去再好好看一下Servlet过滤器。

## SpringSecurity简介

> 早期都是XML配置，学习成本很高，自从出了SpringBoot版本之后，又火起来了。

Spring Security 的前身是Acegi Security，在被收纳为Spring 子项目后正式更名为Spring Security。Spring Security目前已经到了6.x，并且加入了原生OAuth2.0框架，支持更加现代化的密码加密方式。可以预见，在Java应用安全领域，Spring Security会成为被首先推崇的解决方案，就像我们看到服务器就会联想到Linux一样顺理成章。

**应用程序的安全性通常体现在两个方面：认证和授权。**

* **认证**是确认某主体在某系统中是否合法、可用的过程。这里的主体既可以是登录系统的用户，也可以是接入的设备或者其他系统。

* **授权**是指当主体通过认证之后，是否允许其执行某项操作的过程。

这些概念并非Spring Security独有，而是应用安全的基本关注点。Spring Security可以帮助我们更便捷地完成认证和授权。

Spring Security 支持广泛的认证技术，这些认证技术大多由第三方或相关标准组织开发。Spring Security已经集成的认证技术如下：

◎ HTTP BASIC authentication headers：一个基于IETF RFC的标准。

◎ HTTP Digest authentication headers：一个基于IETF RFC的标准。

◎ HTTP X.509 client certificate exchange：一个基于IETF RFC的标准。

◎ LDAP：一种常见的跨平台身份验证方式。

◎ Form-based authentication：用于简单的用户界面需求。

◎ OpenID authentication：一种去中心化的身份认证方式。

◎ Authentication based on pre-established request headers：类似于Computer Associates SiteMinder，一种用户身份验证及授权的集中式安全基础方案。

◎ Jasig Central Authentication Service：单点登录方案。

◎ Transparent authentication context propagation for Remote Method Invocation（RMI）and HttpInvoker：一个Spring远程调用协议。

◎ Automatic "remember-me" authentication：允许在指定到期时间前自行重新登录系统。

◎ Anonymous authentication：允许匿名用户使用特定的身份安全访问资源。

◎ Run-as authentication：允许在一个会话中变换用户身份的机制。

◎ Java Authentication and Authorization Service:JAAS,Java验证和授权API。

◎ Java EE container authentication：允许系统继续使用容器管理这种身份验证方式。

◎ Kerberos：一种使用对称密钥机制，允许客户端与服务器相互确认身份的认证协议。

除此之外，Spring Security还引入了一些第三方包，用于支持更多的认证技术，如JOSSO等。如果所有这些技术都无法满足需求，则Spring Security允许我们编写自己的认证技术。因此，在绝大部分情况下，当我们有Java应用安全方面的需求时，选择Spring Security往往是正确而有效的。

Internet工程任务组（Internet Engineering Task Force,IETF）是推动Internet标准规范制定的最主要的组织。请求注解（Request For Comments,RFC）包含大多数关于Internet的重要文字资料，被称为“网络知识圣经”。

**在授权上，Spring Security不仅支持基于URL对Web的请求授权，还支持方法访问授权、对象访问授权等，基本涵盖常见的大部分授权场景。**

很多时候，一个系统的安全性完全取决于系统开发人员的安全意识。例如，在我们从未听过SQL 注入时，如何意识到要对SQL注入做防护？关于Web系统安全的攻击方式非常多，诸如：XSS、CSRF 等，未来还会暴露出更多的攻击方式，我们只有在充分了解其攻击原理后，才能提出完善而有效的防护策略。在笔者看来，学习Spring Security并非局限于降低Java应用的安全开发成本，通过Spring Security了解常见的安全攻击手段以及对应的防护方法也尤为重要，这些是脱离具体开发语言而存在的。

### 创建一个简单的SpringSecurity项目

本节创建一个简单的Spring Security项目，带领大家初步领略Spring Security带来的便利。下面我们就完整地“走”一遍创建项目的流程。

~~~java
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.1.2</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.boot</groupId>
    <artifactId>spring-security01-helloworld</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>spring-security01-helloworld</name>
    <description>spring-security01-helloworld</description>
    <properties>
        <java.version>17</java.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
~~~

从代码中可以看到，在选择Security之后，Spring Initializr自动引入spring-security-web和spring- security-config两个核心模块，这正是官方建议引入的Spring Security最小依赖。当需要引入更多的Spring Security特征时，再编辑pom.xml文件即可。如果不通过Spring Initializr添加Spring Security的相关依赖，则手动将依赖信息添加到pom.xml文件也是可以的。

申明一个hello控制器：

~~~java
package com.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String hello(){
        return "Hello SpringSecurity!";
    }
}
~~~

启动SpringBoot：

~~~java
package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
~~~

接着打开浏览器访问	http://localhost:8080，浏览器将弹出一个需要进行身份验证的对话框，如图所示。

![](SpringSecurity6笔记/01.png)

在引入Spring Security项目之后，虽然没有进行任何相关的配置或编码，但Spring Security有一个默认的运行状态，要求在经过HTTP基本认证后才能访问对应的URL资源，其默认使用的用户名为user，密码则是动态生成并打印到控制台的一串随机码。翻看控制台的打印信息，可以看到如图所示的输出。

![](SpringSecurity6笔记/02.png)

输入用户名和密码后，单击“登录”按钮即可成功访问hello页面，如图所示。

~~~
Hello SpringSecurity
~~~

#### 修改默认账号密码

当然，在HTTP基本认证中，用户名和密码都是可以配置的，最常见的就是在resources下的配置文件中修改，如下所示。打开application.yml，输入以下配置信息：

~~~java
spring:
  security:
    user:
      name: admin
      password: 123456
~~~

重新启动程序，发现控制台不再打印默认密码串了，此时使用我们自定义的用户名和密码即可登录。

事实上，绝大部分Web应用都不会选择HTTP基本认证这种认证方式，除安全性差、无法携带cookie等因素外，灵活性不足也是它的一个主要缺点。通常大家更愿意选择表单认证，自己实现表单登录页和验证逻辑，从而提高安全性。

## Spring Security 和Shiro对比

> 另外还有一款国人设计的权限认证框架：https://sa-token.cc/

### 概述 

Spring Security 的前身是 Acegi Security，在被收纳为Spring子项目后正式更名为Spring Security。

Spring Security是 Spring 家族中的一个安全管理框架。相比与另外一个安全框架Shiro，它提供了更丰富的功能，社区资源也比Shiro丰富；

 Spring Security是一个功能强大且高度可定制的身份验证和访问控制框架。它是用于保护基于Spring的应用程序的实际标准；

 Spring Security是一个框架，致力于为Java应用程序提供身份验证和授权。与所有Spring项目一样，Spring Security的真正强大之处在于可以轻松扩展以满足自定义要求。

 在 Java 生态中，目前有 Spring Security 和 Apache Shiro 两个安全框架，可以完成认证和授权的功能。

我们先来学习下 Spring Security 。其官方对自己介绍如下：

~~~xml
Spring Security is a powerful and highly customizable authentication and 
access-control framework. 
It is the de-facto standard for securing Spring-based applications.

Spring Security is a framework that focuses on providing both authentication 
and authorization to Java applications. Like all Spring projects, 
the real power of Spring Security is found in how easily it can be extended 
to meet custom requirements

Spring Security是一个功能强大且高度可定制的身份验证和访问控制框架。
它是保护基于Spring的应用程序的事实标准。

Spring Security是一个专注于为 Java 应用程序提供身份验证和授权的框架。
像所有 Spring 项目一样，Spring Security的真正威力在于它可以轻松扩展以满足自定义需求。
~~~

一般Web应用的需要进行认证和授权。

 认证（Authentication）：验证当前访问系统的是不是本系统的用户，并且要确认具体是哪个用户

 授权（Authorization）：经过认证后判断当前用户是否有权限进行某个操作

 而认证和授权就是SpringSecurity作为安全框架的核心功能。

### Spring Security、Apache Shiro 选择问题

#### Shiro

首先Shiro较之 Spring Security，Shiro在保持强大功能的同时，还在简单性和灵活性方面拥有巨大优势。

Shiro是一个强大而灵活的开源安全框架，能够非常清晰的处理认证、授权、管理会话以及密码加密。如下是它所具有的特点：

1. 易于理解的 Java Security API；
2. 简单的身份认证（登录），支持多种数据源（LDAP，JDBC，Kerberos，ActiveDirectory 等）；
3. 对角色的简单的签权（访问控制），支持细粒度的签权；
4. 支持一级缓存，以提升应用程序的性能；
5. 内置的基于 POJO 企业会话管理，适用于 Web 以及非 Web 的环境；
6. 异构客户端会话访问；
7. 非常简单的加密 API；
8. 不跟任何的框架或者容器捆绑，可以独立运行。

Shiro四大核心功能:Authentication,Authorization,Cryptography,Session Management

![](SpringSecurity6笔记/03.png)

四大核心功能介绍：

1. Authentication：身份认证/登录，验证用户是不是拥有相应的身份；
2. Authorization：授权，即权限验证，验证某个已认证的用户是否拥有某个权限；即判断用户是否能做事情，常见的如：验证某个用户是否拥有某个角色。或者细粒度的验证某个用户对某个资源是否具有某个权限；
3. Session Manager：会话管理，即用户登录后就是一次会话，在没有退出之前，它的所有信息都在会话中；会话可以是普通JavaSE环境的，也可以是如Web环境的；
4. Cryptography：加密，保护数据的安全性，如密码加密存储到数据库，而不是明文存储；

Shiro架构

Shiro三个核心组件：Subject, SecurityManager 和 Realms.

1. Subject：主体，可以看到主体可以是任何可以与应用交互的 用户；
2. SecurityManager：相当于 SpringMVC 中的 DispatcherServlet 或者 Struts2 中的 FilterDispatcher；是 Shiro 的心脏；所有具体的交互都通过 SecurityManager 进行控制；它管理着所有 Subject、且负责进行认证和授权、及会话、缓存的管理。
3. Realm：域，Shiro从从Realm获取安全数据（如用户、角色、权限），就是说SecurityManager要验证用户身份，那么它需要从Realm获取相应的用户进行比较以确定用户身份是否合法；也需要从Realm得到用户相应的角色/权限进行验证用户是否能进行操作；可以把Realm看成DataSource，即安全数据源。

##### shiro的优点

- shiro的代码更易于阅读，且使用更加简单；
- shiro可以用于非web环境，不跟任何框架或容器绑定，独立运行；

##### shiro的缺点

- 授权第三方登录需要手动实现；

#### Spring Security

除了不能脱离Spring，shiro的功能它都有。而且Spring Security对Oauth、OpenID也有支持,Shiro则需要自己手动实现。Spring Security的权限细粒度更高,毕竟Spring Security是Spring家族的。

Spring Security一般流程为：

1. 当用户登录时，前端将用户输入的用户名、密码信息传输到后台，后台用一个类对象将其封装起来，通常使用的是UsernamePasswordAuthenticationToken这个类。
2. 程序负责验证这个类对象。验证方法是调用Service根据username从数据库中取用户信息到实体类的实例中，比较两者的密码，如果密码正确就成功登陆，同时把包含着用户的用户名、密码、所具有的权限等信息的类对象放到SecurityContextHolder（安全上下文容器，类似Session）中去。
3. 用户访问一个资源的时候，首先判断是否是受限资源。如果是的话还要判断当前是否未登录，没有的话就跳到登录页面。
4. 如果用户已经登录，访问一个受限资源的时候，程序要根据url去数据库中取出该资源所对应的所有可以访问的角色，然后拿着当前用户的所有角色一一对比，判断用户是否可以访问（这里就是和权限相关）。

##### spring-security的优点

- spring-security对spring整合较好，使用起来更加方便；
- 有更强大的spring社区进行支持；
- 支持第三方的 oauth 授权，官方网站：[spring-security-oauth](https://spring.io/projects/spring-security-oauth)

## SpringSecurity 第一个项目

### 创建一个SpringBoot项目 

添加如下依赖：spring-boot-starter-security

~~~java
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.1.2</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.boot</groupId>
    <artifactId>spring-security01-helloworld</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>spring-security01-helloworld</name>
    <description>spring-security01-helloworld</description>
    <properties>
        <java.version>17</java.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
~~~

### 加入测试Controller

~~~java
package com.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "World Hello";
    }
}
~~~

### 启动项目

![](SpringSecurity6笔记/04.png)

### 查看登录密码

在控制台有登录密码日志输出

![](SpringSecurity6笔记/05.png)

### 访问项目

<http://localhost:8080/>

自动跳转到：<http://localhost:8080/login>

> SpringSecurity底层默认自带了一个过滤器，拦截判断是否登录，没有的话会跳转到Login页面
>
> Spring Security默认登录页面代码是从此类生成的：`org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter`

用户名：user

密码：dcb97d95-1233-4f18-a82f-a7bb8cb95e28

![](SpringSecurity6笔记/06.png)

### 修改默认的账号密码

~~~java
spring:
  security:
    user:
      name: admin
      password: admin
~~~

### 退出

http://localhost:8080/logout

## SpringSecurity 自定义登录页面

### 配置

~~~java
package com.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @EnableWebSecurity:SpringSecurity的配置类 开启SpringSecurity【自带大量过滤器链:责任链模式】
 */
@Configuration //
@EnableWebSecurity //5.x中@EnableWebSecurity自带@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorizeHttpRequests-> //在这个后面开始配置URL相关的【URL访问权限控制相关的】
                        authorizeHttpRequests.requestMatchers("/login").permitAll() //permitAll:授予所有权限【匿名可以访问的、不用登录就可以访问】
                                .anyRequest() //任何的请求
                                .authenticated() //需要认证【登录】后才能访问
                )

                .formLogin(formLogin->
                        formLogin.loginPage("/login") //登录页面
                                .loginProcessingUrl("/login").permitAll() //登录接口可以匿名访问
                                .defaultSuccessUrl("/index") //登录成功访问/index页面

                )
                .csrf(Customizer.withDefaults()) //关闭跨域漏洞攻击防护
                .logout(logout->logout.deleteCookies("JSESSIONID").invalidateHttpSession(true).logoutSuccessUrl("/index")) //退出登录接口
                .build();

    }
}
~~~

### 登录控制器

~~~java
package security03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login(){
		return "login";
	}
}
~~~

### 登录页面

~~~java
<!DOCTYPE html>
<html xmlns:th="https://www.thymeleaf.org">
    <head>
        <title>请登录</title>
    </head>
    <body>
        <div>
            <form th:action="@{/login}" method="post">
                <p>
                    <span>用户名:</span>
                    <input type="text" id="username" name="username">
                </p>
                <p>
                    <span>密码:</span>
                    <input type="password" id="password" name="password">
                </p>

                <!-- 不使用 th:action 属性 和 不关闭csrf 的情况下，需要放开下面的标签 -->
                <!--<input th:name="${_csrf.parameterName}" type="hidden" th:value="${_csrf.token}"/>-->

                <input type="submit" value="登录" />
            </form>
        </div>
    </body>
</html>
~~~

### 退出：注意，退出是post请求！！！

~~~java
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>系统首页</title>
</head>
<body>
<h1 style="background-color: goldenrod">欢迎访问系统</h1>
<form th:action="@{/logout}" method="post">
    <input type="submit" value="退出系统"/>
</form>
</body>
</html>
~~~

## Spring Security 前后端分离认证

我们初步引入了Spring Security，并使用其默认生效的HTTP基本认证来保护URL资源，本章我们使用表单认证来保护URL资源。

### 前后端分离模式 

表单登录配置模块提供了successHandler（）和failureHandler（）两个方法，分别处理登录成功和登录失败的逻辑。其中，successHandler()方法带有一个Authentication参数，携带当前登录用户名及其角色等信息；而failureHandler()方法携带一个AuthenticationException异常参数。具体处理方式需按照系统的情况自定义。

~~~xml
axios请求头修改
'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
~~~

~~~java
package com.boot.config;

import com.boot.security.LoginFailureHandler;
import com.boot.security.LoginSuccessHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

import static org.springframework.security.config.Customizer.withDefaults;

//@EnableWebSecurity:开启SpringSecurity 之后会默认注册大量的过滤器servlet filter
//过滤器链【责任链模式】SecurityFilterChain
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //authorizeHttpRequests:针对http请求进行授权配置
        //login登录接口需要匿名访问
        //permitAll:具有所有权限 也就可以匿名可以访问
        //anyRequest:任何请求 所有请求
        //authenticated:认证【登录】
        http.authorizeHttpRequests(authorizeHttpRequests->
                authorizeHttpRequests
                        .requestMatchers("/login").permitAll()
                        .anyRequest().authenticated()
        );

        //http:后面可以一直点 但是太多内容之后不美观
        //loginProcessingUrl:指定登录接口
        //successHandler:登录成功处理器
        //failureHandler:登录失败处理器
        //自定义登录接口
        http.formLogin(formLogin->
                formLogin
                        .loginProcessingUrl("/login").permitAll()
                        .successHandler(new LoginSuccessHandler())
                        .failureHandler(new LoginFailureHandler())
        );

        //Customizer.withDefaults():关闭
        //http.csrf(Customizer.withDefaults());//跨域漏洞防御:关闭
        //http.csrf(e->e.disable());
        //http.csrf(crsf->crsf.disable());//相当于 http.csrf(Customizer.withDefaults());
        http.csrf(e->e.disable());//封装的太过于抽象比较难以阅读代码【装X】

        http.cors(e->e.disable());//跨域拦截关闭

        return http.build();
    }

}
~~~

在形式上，我们确实使用了SpringSecurity的表单认证功能，并且自定义了表单登录页。但实际上，这还远远不够。例如，在实际系统中，我们正常登录时使用的用户名和密码都来自数据库，这里却都写在配置上。更进一步，我们可以对每个登录用户都设定详细的权限，而并非一个通用角色。这些内容将在后面章节讲解。

## 有关前端部署命令

~~~
npm init vite@latest
npm install vue-router@4
npm install axios
~~~

## Spring Security 认证过程源码分析