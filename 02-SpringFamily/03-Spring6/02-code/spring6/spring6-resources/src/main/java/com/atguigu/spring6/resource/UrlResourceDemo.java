package com.atguigu.spring6.resource;

import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * @Author liming
 * @Date 2023/9/22 14:46
 **/

//演示urlResource网络资源
public class UrlResourceDemo {
    public static void main(String[] args) {
        //http前缀
        //loadUrlResource("http://www.baidu.com");

        //file前缀
        loadUrlResource("file:atguigu.txt");
    }

    //访问前缀http、file
    public static void loadUrlResource(String path){
        // 创建一个Resource实现类的对象 UrlResource
        try {
            UrlResource url = new UrlResource(path);
            //获取资源信息
            System.out.println(url.getFilename());
            System.out.println(url.getURI());
            System.out.println(url.getDescription());
            System.out.println(url.getInputStream().read());
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }
}
