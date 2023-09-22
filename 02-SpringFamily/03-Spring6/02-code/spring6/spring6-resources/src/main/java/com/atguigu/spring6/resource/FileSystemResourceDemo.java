package com.atguigu.spring6.resource;

import org.springframework.core.io.FileSystemResource;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author liming
 * @Date 2023/9/22 15:54
 **/

//访问系统中的资源
public class FileSystemResourceDemo {
    public static void main(String[] args) {
        //loadFileResource("d:\\atguigu.txt");   //绝对路径
        loadFileResource("atguigu.txt");    //相对路径  读项目根路径下文件
    }

    public static void loadFileResource(String path){
        //创建对象
        FileSystemResource resource = new FileSystemResource(path);
        System.out.println(resource.getFilename());
        System.out.println(resource.getDescription());
        try {
            InputStream in = resource.getInputStream();
            byte[] b = new byte[1024];
            while (in.read(b) != -1){
                System.out.println(new String(b));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
