package com.atguigu.spring6.resource;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author liming
 * @Date 2023/9/22 14:55
 **/

//访问类路径下的资源
public class ClassPathResourceDemo {
    public static void loadClassPathResource(String path){
        //创建对象ClassPathResource
        ClassPathResource resource = new ClassPathResource(path);
        System.out.println(resource.getFilename());
        System.out.println(resource.getDescription());
        //获取文件内容
        try {
            InputStream in = resource.getInputStream();
            byte[] b = new byte[1024];
            //这个循环是：每次取1024，直到取完
            while (in.read(b) != -1){
                System.out.println(new String(b));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        loadClassPathResource("atguigu.txt");
    }
}
