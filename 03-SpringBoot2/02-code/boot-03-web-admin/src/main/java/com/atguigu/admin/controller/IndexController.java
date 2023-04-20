package com.atguigu.admin.controller;

import com.atguigu.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * @Author liming
 * @Date 2023/4/6 16:59
 **/
@Controller
public class IndexController {
    /**
     * 来登录页
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    //public String main(String username,String password){
    public String main(User user, HttpSession session, Model model){
        if(StringUtils.hasLength(user.getUserName()) && "123456".equals(user.getPassword())){
            //把登录成功的用户保存起来
            session.setAttribute("loginUser",user);
            //登录成功，重定向到main页面，重定向可以防止表单重复提交
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","账号密码错误");
            //又回到登录页
            return "login";
        }
    }

    /**
     * 去main页面
     * @return
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){
        //是否登录 拦截器，过滤器，现在为了方便，写在方法里面
        Object loginUser = session.getAttribute("loginUser");
        if(loginUser != null){
            return "main";
        }else{
            //回到登录页面
            model.addAttribute("msg","请重新登录");
            return "main";
        }
    }
}
