package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author liming
 * @Date 2023/1/14 15:55
 **/

/**
 * 获取请求参数的方式：
 * 1、通过servletAPI获取
 * 只需要在控制器方法的形参位置设置HttpServletRequest类型的形参
 * 就可以在控制器方法中使用request对象获取请求参数
 * 2、通过控制器方法的形参获取
 * 只需要在控制器方法的形参位置，设置一个形参，形参的名字和请求参数的名字一致即可
 * 3、@RequestParam：将请求参数和控制器方法的形参绑定
 * @RequestParam注解的三个属性：value、required、defaultValue
 * value:设置和形参绑定的请求参数的名字
 * required:设置是否必须传输value所对应的请求参数
 * 默认值为true，表示value所对应的请求参数必须传输，否则页面报错：
 * 400 - Required String parameter 'xxx' is not present
 * 若设置为false，则表示value所对应的请求参数不是必须传输，若为传输，则形参值为null
 * defaultValue:设置当没有传输value所对应的请求参数时，为形参设置的默认值，此时和required属性值无关
 * 4、@RequestHeader：将请求头信息和控制器方法的形参绑定
 * 5、@CookieValue：将cookie数据和控制器方法的形参绑定
 * 6、通过控制器方法的实体类类型的形参获取请求参数
 * 需要在控制器方法的形参位置设置实体类类型的形参，要保证实体类中的属性的属性名和请求参数的名字一致
 * 可以通过实体类类型的形参获取请求参数
 * 7、解决获取请求此参数的乱码问题
 * 在web.xml中配置Spring的编码过滤器CharacterEncodingFilter
 */
@Controller
public class TestParamController {
    @RequestMapping("/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username+",password:"+password);
        System.out.println(session);
        return "success";
    }

    @RequestMapping("/param")
    public String getParam(String username,String password){
        System.out.println("username:"+username+",password:"+password);
        return "success";
    }

    @RequestMapping("/param2")
    public String getParam2(
            //@RequestParam("userName")
            @RequestParam(value = "userName",required = false,defaultValue = "zhangsan")
            String username,
            String password
    ){
        System.out.println("username:"+username+",password:"+password);
        return "success";
    }

    @RequestMapping("/param3")
    public String getParam3(
            @RequestParam(value = "userName",required = false,defaultValue = "hello")
            String username,
            String password,
            @RequestHeader("referer") String referer,
            @CookieValue("JSESSIONID") String jsessionId

    ){
        System.out.println("referer" + referer);
        System.out.println("username:"+username+",password:"+password);
        System.out.println("jsessionId" + jsessionId);
        return "success";
    }
}
