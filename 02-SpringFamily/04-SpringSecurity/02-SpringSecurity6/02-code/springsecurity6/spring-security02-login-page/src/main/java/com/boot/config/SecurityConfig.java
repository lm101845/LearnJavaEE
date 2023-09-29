package com.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @Author liming
 * @Date 2023/9/28 15:51
 **/

@EnableWebSecurity
@Configuration
/**
 * @EnableWebSecurity是开启SpringSecurity的默认行为，
 * 它的上面有一个Import注解导入了WebSecurityConfiguration类，
 * 也就是说我们加上了@EnableWebSecurity这个注解，
 * 就是往IOC容器中注入了WebSecurityConfiguration这个类。
 *
 * 会默认注册大量的过滤器servlet filter
 * 过滤器链(责任链模式)——SecurityFilterChain
 */
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //authorizeHttpRequests:针对http请求进行授权配置
        //login登录页面需要匿名访问
        //permitAll：具有所有权限 也就可以匿名访问
        //anyRequest:任何请求 所有请求
        //authenticated:认证【登录】
        http.authorizeHttpRequests(authorizeHttpRequests ->
                authorizeHttpRequests
                        .requestMatchers("/login")
                        .permitAll()
                        .anyRequest()
                        .authenticated()

        );
        //http:后面可以一直点，但是太多内容之后不美观
        //loginPage:登录页
        //loginProcessingUrl:登录接口 过滤器
        //defaultSuccessUrl：登录成功之后跳转的页面
        http.formLogin(formLogin ->
                formLogin
                        .loginPage("/login")
                        .permitAll()
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/index")
        );

        /**
         * http.authorizeHttpRequests是Spring Security 5中引入的一种新的安全性配置方法，
         * 用于授权HTTP请求。
         * 它使用简化的AuthorizationManager API，而不是元数据源、配置属性、决策管理器和选民，
         * 简化了重用和定制。通过使用http.authorizeHttpRequests方法，
         * 你可以指定一个或多个要求身份验证的请求，并定义如何对它们进行授权。
         *
         * http.formLogin是Spring Security 4及之前版本中使用的旧方法，用于实现表单登录。
         * 这个方法会弹出一个表单登录页面，让用户输入用户名和密码进行身份验证。
         * 验证后，用户的身份信息将被存储在服务器上，以便在随后的请求中进行身份验证。
         *
         * 简单来说，http.authorizeHttpRequests是Spring Security 5及以后版本中用于
         * 授权HTTP请求的新方法，而http.formLogin则是Spring Security 4及之前版本中用于
         * 实现表单登录的旧方法。
         */

        //写法1：封装的太过抽象，比较难以阅读代码
        //http.csrf(Customizer.withDefaults());   //跨域漏洞防御：关闭
        //写法2：
        http.csrf(csrf->csrf.disable());

        //退出
        http.logout(logout->logout.invalidateHttpSession(true));

        return http.build();
    }
}
