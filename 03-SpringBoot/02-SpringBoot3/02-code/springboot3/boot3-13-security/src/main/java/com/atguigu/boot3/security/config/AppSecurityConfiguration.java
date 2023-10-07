package com.atguigu.boot3.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @Author liming
 * @Date 2023/10/7 22:14
 **/
@Configuration
public class AppSecurityConfiguration {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //请求授权
        http.authorizeHttpRequests(registry->{
            registry.requestMatchers("/").permitAll()   //1、首页所有人都允许
                    .anyRequest().authenticated();  //2、剩下的任意请求都需要 认证（登录）
        });
        //表单登录
        //3、表单登录功能：开启默认表单登录功能；Spring Security提供默认登录页
        //http.formLogin();
        http.formLogin(formLogin -> {
            formLogin.loginPage("/login").permitAll(); //自定义登录页位置，并且所有人都能访问
        });
        return http.build();
    }


    @Bean //查询用户详情；这里老师使用内存保存，没有用数据库保存了
    UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
        UserDetails zhangsan = User.withUsername("zhangsan")
                .password(passwordEncoder.encode("123456")) //使用密码加密器加密密码进行存储
                .roles("admin", "hr")   //角色
                .authorities("file_read", "file_write")   //权限
                .build();

        UserDetails lisi = User.withUsername("lisi")
                .password(passwordEncoder.encode("123456"))
                .roles("hr")
                .authorities("file_read")
                .build();

        UserDetails wangwu = User.withUsername("wangwu")
                .password(passwordEncoder.encode("123456"))
                .roles("admin")
                .authorities("file_write","world_exec1")
                .build();

        //模拟内存中保存所有用户信息
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager(zhangsan,lisi,wangwu);
        return manager;
    }

    @Bean //密码加密器
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
