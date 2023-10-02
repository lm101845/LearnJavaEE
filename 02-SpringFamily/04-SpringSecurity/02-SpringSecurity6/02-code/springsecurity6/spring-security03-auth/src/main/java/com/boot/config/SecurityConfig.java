package com.boot.config;

import com.boot.security.LoginFailureHandler;
import com.boot.security.LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;


/**
 * @Author liming
 * @Date 2023/9/29 18:09
 **/

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizeHttpRequests ->
                authorizeHttpRequests
                        //===============================角色==============================================
                        //.requestMatchers("/admin/api").hasRole("admin")   //必须有admin角色才能访问到
                        //.requestMatchers("/user/api").hasAnyRole("admin","user")   //admin、user都可以访问

                        //===============================权限==============================================
                        .requestMatchers("/admin/api").hasAuthority("admin:api")   //必须有admin:api权限才能访问到
                        .requestMatchers("/user/api").hasAnyAuthority("admin:api","user:api")   //必须有admin:api权限才能访问到

                        //===============================匹配模式==============================================
                        .requestMatchers("/admin/api/?").hasAuthority("admin:api")
                        .requestMatchers("user/api/my/*").hasAuthority("admin:api")

                        .requestMatchers("/app/api").permitAll()   //游客登录(匿名访问)

                        .requestMatchers("/login").permitAll()
                        .anyRequest().authenticated()
        );

        //异常处理
        http.exceptionHandling(e-> e.accessDeniedPage("/noAuth"));

        http.formLogin(formLogin ->
                formLogin
                        .loginPage("/login")
                        //.successHandler(new LoginSuccessHandler())
                        //.failureHandler(new LoginFailureHandler())
                        .permitAll()
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/index")
        );

        http.csrf(csrf->csrf.disable());

        //关闭跨域拦截
        http.cors(Customizer.withDefaults());

        //退出
        http.logout(logout->logout.invalidateHttpSession(true));

        return http.build();
    }


    //@Bean
    //public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
    //    //admin用户具有admin、user角色
    //    UserDetails user1 = User.withUsername("admin").password("123456").authorities("admin:api","user:api").build();
    //    ////user用户只有user角色
    //    UserDetails user2 = User.withUsername("user").password("123456").roles("user:api").build();
    //    return new InMemoryUserDetailsManager(user1,user2);
    //}

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(PasswordEncoder passwordEncoder) {
        //admin用户具有admin、user角色
        UserDetails user1 = User.withUsername("admin").password(passwordEncoder.encode("123456")).authorities("admin:api","user:api").build();
        //user用户只有user角色
        UserDetails user2 = User.withUsername("user").password(passwordEncoder.encode("123456")).roles("user:api").build();
        return new InMemoryUserDetailsManager(user1,user2);
    }



    /**
     * PasswordEncoder：加密编码
     * 实际开发中开发环境一般是明文加密，在生产环境中是密文加密
     * 也就是说可以配置多种加密方式
     * @return
     */
    //public PasswordEncoder passwordEncoder(){
    //    return NoOpPasswordEncoder.getInstance();
    //}
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
