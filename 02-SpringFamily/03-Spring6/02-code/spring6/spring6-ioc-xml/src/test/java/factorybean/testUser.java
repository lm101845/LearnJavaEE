package factorybean;

import com.atguigu.spring6.iocxml.factorybean.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author liming
 * @Date 2023/9/18 16:15
 **/
public class testUser {
    @Test
    public void demo1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-factorybean.xml");
        User user =(User) context.getBean("user");
        System.out.println(user);
    }

}
