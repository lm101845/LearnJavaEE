import com.atguigu.spring6.iocxml.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author liming
 * @Date 2023/9/16 21:37
 **/
public class testUser {

    //根据id获取bean
    @Test
    public void testGetUserById(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = (User) context.getBean("user");   //user就是bean设置的id值
        System.out.println("根据id获取的bean:====>" + user);
    }

    //根据类型获取bean
    @Test
    public void testGetUserByType(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = (User) context.getBean(User.class);
        System.out.println("根据类型获取的bean:====>" + user);
    }

    //根据id和类型获取bean
    @Test
    public void testGetUserByIdAndType(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = (User) context.getBean("user",User.class);
        System.out.println("根据id和类型获取的bean:====>" + user);
    }
}
