package com.boot.controller;

import com.boot.security.LoginFailureHandler;
import com.boot.security.LoginSuccessHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
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

/**
 * @Author liming
 * @Date 2023/9/28 17:44
 **/

@EnableWebSecurity
@Configuration
@Slf4j
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //authorizeHttpRequests:针对http请求进行授权配置
        //login登录接口需要匿名访问
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
        //loginProcessingUrl:指定登录接口
        //successHandler:登录成功处理器
        //failureHandler:登录失败处理器
        //自定义登录接口？？？
        http.formLogin(formLogin ->
                formLogin
                        .loginProcessingUrl("/login")
                        //写法1：
                        //.successHandler(new AuthenticationSuccessHandler() {
                        //    @Override
                        //    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        //        response.setContentType("text/html;charset=UTF-8");
                        //        response.getWriter().write("loginOK");
                        //        log.info("successHandler" + authentication.getPrincipal());
                        //        log.info("authentication.getCredentials()" + authentication.getCredentials());
                        //        log.info("authentication.getAuthorities()" + authentication.getAuthorities());
                        //    }
                        //})
                        //写法2：代码抽离
                        .successHandler(new LoginSuccessHandler())
                        .failureHandler(new LoginFailureHandler())
        );

        //关闭csrf
        http.csrf(csrf->csrf.disable());

        //关闭跨域拦截
        http.cors(Customizer.withDefaults());

        return http.build();
    }
}
