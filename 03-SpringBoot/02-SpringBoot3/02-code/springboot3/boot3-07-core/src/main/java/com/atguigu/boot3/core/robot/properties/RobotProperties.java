package com.atguigu.boot3.core.robot.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author liming
 * @Date 2023/10/3 12:15
 **/

@ConfigurationProperties(prefix = "robot")
@Component
@Data
public class RobotProperties {
    private String name;
    private String age;
    private String email;
}
