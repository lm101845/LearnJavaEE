package com.atguigu.boot3.robotstater.robot;

import com.atguigu.boot3.robotstater.robot.controller.RobotController;
import com.atguigu.boot3.robotstater.robot.properties.RobotProperties;
import com.atguigu.boot3.robotstater.robot.service.RobotService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author liming
 * @Date 2023/10/3 12:52
 **/

//使用@Import注解给容器中导入Robot功能要用的所有组件
@Import({RobotController.class, RobotProperties.class, RobotService.class})
@Configuration
public class RobotAutoConfiguration {

}
