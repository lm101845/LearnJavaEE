package autowiredset;

import com.atguigu.spring6.autowiredset.controller.UserController1;
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
        UserController1 controller = context.getBean(UserController1.class);
        controller.add();
    }
}
