package com.atguigu.boot3.robotstater.robot.annotation;

import com.atguigu.boot3.robotstater.robot.RobotAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Author liming
 * @Date 2023/10/3 13:16
 **/

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import(RobotAutoConfiguration.class)
public @interface EnableRobot {
}
