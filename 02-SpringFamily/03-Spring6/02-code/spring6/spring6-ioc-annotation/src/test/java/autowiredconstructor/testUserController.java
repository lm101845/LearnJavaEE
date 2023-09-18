package autowiredconstructor;

import com.atguigu.spring6.autowiredconstructor.controller.UserController2;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author liming
 * @Date 2023/9/18 18:19
 **/
public class testUserController {
    @Test
    public void demo1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserController2 controller = context.getBean(UserController2.class);
        controller.add();
    }
}
