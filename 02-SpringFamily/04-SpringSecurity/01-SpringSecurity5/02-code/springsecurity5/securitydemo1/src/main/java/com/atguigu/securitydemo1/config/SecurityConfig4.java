package com.atguigu.securitydemo1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author liming
 * @Date 2023/10/3 19:36
 **/

@Configuration
public class SecurityConfig4 extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    @Bean
    PasswordEncoder password(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        //配置没有权限访问跳转页面
        http.exceptionHandling().accessDeniedPage("/unauth.html");
        http.formLogin()  //自定义自己编写的登录页面
            .loginPage("/login.html")      //登录页面设置
            .loginProcessingUrl("/user/login")        //登录访问路径
            .defaultSuccessUrl("/test/index").permitAll()   //登录成功【之后】，跳转路径
            .and().authorizeRequests()
            .antMatchers("/","/test/hello","/user/login").permitAll()  //设置哪些路径可以直接访问，不需要认证
             //登录(进入房子,房子钥匙)  权限(进入房子里的一个个房间,房间钥匙)

             //方法1：hasAuthority:单个权限
             //.antMatchers("/test/index").hasAuthority("apple")
             //当前登录用户，只有apple权限，才能访问这个路径(虽然可以登录，但是访问这个路径没有权限不行)

            // 方法2:hasAnyAuthority：多个权限
            //.antMatchers("/test/index").hasAnyAuthority("apple,banana")

             //方法3：hasRole   ROLE_sale
            .antMatchers("/test/index").hasRole("sale")
            .anyRequest().authenticated()
            .and().csrf().disable();   //关闭csrf防护
    }
}
