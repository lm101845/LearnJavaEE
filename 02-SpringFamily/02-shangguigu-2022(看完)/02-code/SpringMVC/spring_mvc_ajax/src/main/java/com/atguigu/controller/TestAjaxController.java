package com.atguigu.controller;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author liming
 * @Date 2023/1/19 9:00
 **/

/**
 * 1、@RequestBody：将请求体中的内容和控制器方法的形参进行绑定
 * 2、使用@RequestBody注解将json格式的请求参数转换为java对象
 * a>导入jackson的依赖
 * b>在SpringMVC的配置文件中设置<mvc:annotation-driven />
 * c>在处理请求的控制器方法的形参位置，直接设置json格式的请求参数要转换的java类型的形参，使用@RequestBody注解标识即可
 * 3、@ResponseBody：将所标识的控制器方法的返回值作为响应报文的响应体响应到浏览器
 * 4、使用@ResponseBody注解响应浏览器json格式的数据
 * a>导入jackson的依赖
 * b>在SpringMVC的配置文件中设置<mvc:annotation-driven />
 * c>将需要转换为json字符串的java对象直接作为控制器方法的返回值，使用@ResponseBody注解标识控制器方法
 * 就可以将java对象直接转换为json字符串，并响应到浏览器
 *
 * 常用的Java对象转换为json的结果：
 * 实体类-->json对象
 * map-->json对象
 * list-->json数组
 *
 */
@Controller
//@RestController =   @Controller + @ResponseBody，更加方便
public class TestAjaxController {
    @RequestMapping("/test/ajax")
    public void testAjax(Integer id, @RequestBody String requestBody, HttpServletResponse response) throws IOException {
        System.out.println("requestBody:"+requestBody);
        //return "success";
        //不能这样写，ajax是在服务器不刷新的情况下与页面进行交互,是局部刷新
        System.out.println("id:"+id);
        //这样写的话，它直接响应回去的是一整个页面
        response.getWriter().write("hello,axios");
        //response.getWriter()整个方法不是我们自己调用的，是系统调用的，所以直接抛就可以了
    }

    @RequestMapping("/test/RequestBody/json")
    //写法1：
    //public void testRequestBody(@RequestBody Map<String, Object> map, HttpServletResponse response) throws IOException {
    //    System.out.println(map);
    //    response.getWriter().write("hello,RequestBody-map");
    //}

    //写法2：
    public void testRequestBody(@RequestBody User user, HttpServletResponse response) throws IOException {
        System.out.println(user);
        response.getWriter().write("hello,RequestBody-user");
    }

    @RequestMapping("/test/ResponseBody")
    @ResponseBody
    //ResponseBody这个注解可以不跳转页面(url路径不变)
    //不加注解，实现的是页面跳转，跳转到success这个逻辑视图形成的页面
    public String testResponseBody(){
        return "success";
    }

    //我们这里省略了手动将Java对象通过第三方jar包转换为json字符串的过程
    @RequestMapping("/test/ResponseBody/json")
    @ResponseBody
    public List<User> testResponseBodyJson(){
        User user1 = new User(1001, "admin1", "123456", 20, "男");
        User user2 = new User(1002, "admin2", "123456", 20, "男");
        User user3 = new User(1003, "admin3", "123456", 20, "男");
        List<User> list = Arrays.asList(user1, user2, user3);
        return list;
    }
    //public Map<String, Object> testResponseBodyJson(){
    //    User user1 = new User(1001, "admin1", "123456", 20, "男");
    //    User user2 = new User(1002, "admin2", "123456", 20, "男");
    //    User user3 = new User(1003, "admin3", "123456", 20, "男");
    //    Map<String, Object> map = new HashMap<>();
    //    map.put("1001", user1);
    //    map.put("1002", user2);
    //    map.put("1003", user3);
    //    return map;
    //}

    /*public User testResponseBodyJson(){
        User user = new User(1001, "admin", "123456", 20, "男");
        return user;
    }*/
}
