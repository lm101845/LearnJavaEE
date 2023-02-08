package com.atguigu;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liming
 * @Date 2023/2/8 21:56
 **/

@RestController
public class WorldController1 {
    @RequestMapping("/w1")
    public String world666(){
        return "world-这里不在同一个目录下，无法生效-把包层级放到后可以生效";
        //如果硬要放在外面，其实也是可以的,去MainApplication中，把包的层级放大一点就行了
    }
}
