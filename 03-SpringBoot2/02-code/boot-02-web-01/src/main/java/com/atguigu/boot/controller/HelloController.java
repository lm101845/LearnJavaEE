package com.atguigu.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liming
 * @Date 2023/2/12 18:30
 **/

/**
 * 只要静态资源放在类路径下： called `/static` (or `/public` or `/resources` or `/META-INF/resources`
 * 访问 ： 当前项目根路径/ + 静态资源名
 * 原理： 静态映射/**。
 * 请求进来，先去找Controller看能不能处理。不能处理的所有请求又都交给静态资源处理器。静态资源也找不到则响应404页面。
 * 也可以改变默认的静态资源路径，`/static`，`/public`,`/resources`, `/META-INF/resources`失效
 */
@RestController
public class HelloController {
    @RequestMapping("/bug.jpg")
    public String hello(){
        return "aaa";
        //此时会返回字符串aaa还是返回图片呢？
        //答：返回的是aaa字符串！！！
    }
}
