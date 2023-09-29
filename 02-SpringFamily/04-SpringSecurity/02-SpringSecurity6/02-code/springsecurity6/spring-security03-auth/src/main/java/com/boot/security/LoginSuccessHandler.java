package com.boot.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

/**
 * @Author liming
 * @Date 2023/9/28 18:20
 **/
@Slf4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("loginOK");
        log.info("successHandler" + authentication.getPrincipal());
        log.info("authentication.getCredentials()" + authentication.getCredentials());
        log.info("authentication.getAuthorities()" + authentication.getAuthorities());
    }
}
