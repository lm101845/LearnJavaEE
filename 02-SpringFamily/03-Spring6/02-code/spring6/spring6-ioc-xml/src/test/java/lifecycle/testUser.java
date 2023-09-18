package lifecycle;

import com.atguigu.spring6.iocxml.lifecycle.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author liming
 * @Date 2023/9/18 15:56
 **/
public class testUser {
    @Test
    public void demo1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-life.xml");
        Object user = context.getBean("user", User.class);
        System.out.println("6:bean对象创建完成了，可以使用了");
        System.out.println(user);
        context.close();   //销毁bean容器(对象自然也销毁了)
    }
}
