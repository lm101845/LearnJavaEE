package bean;

import com.atguigu.spring6.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author liming
 * @Date 2023/9/18 17:40
 **/
public class testUser {
    @Test
    public void demo1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = context.getBean(User.class);
        System.out.println(user);
    }
}
