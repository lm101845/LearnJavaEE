package com.atguigu.boot3.robotstater.robot.service;


import com.atguigu.boot3.robotstater.robot.properties.RobotProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author liming
 * @Date 2023/10/3 12:13
 **/

@Service
public class RobotService {
    @Autowired
    RobotProperties robotProperties;

    public String sayHello(){
        return "你好，名字：【" + robotProperties.getName() + "】；年龄：【" + robotProperties.getAge() + "】";
    }
}
