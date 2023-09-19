package autoconfig;

import com.atguigu.spring6.autoconfig.Spring6Config;
import com.atguigu.spring6.resource.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author liming
 * @Date 2023/9/19 21:41
 **/
public class testAutoConfig {
    @Test
    public void demo1(){
        ApplicationContext context = new AnnotationConfigApplicationContext(Spring6Config.class);
        UserController controller = context.getBean(UserController.class);
        controller.add();
    }
}
