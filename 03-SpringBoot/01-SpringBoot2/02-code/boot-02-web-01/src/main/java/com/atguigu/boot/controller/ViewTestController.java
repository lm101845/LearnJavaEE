package com.atguigu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author liming
 * @Date 2023/3/25 21:11
 **/
@Controller
public class ViewTestController {
    @GetMapping("/atguigu")
    public String atguigu(Model model){
        //model中的数据会被放在请求域中 request.setAttribute("a",aa)
        model.addAttribute("msg","你好，世界");
        model.addAttribute("link","http://www.baidu.com");
        return "success";
    }
}
