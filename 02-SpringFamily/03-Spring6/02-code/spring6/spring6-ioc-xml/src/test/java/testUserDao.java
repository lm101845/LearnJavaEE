import com.atguigu.spring6.iocxml.User;
import com.atguigu.spring6.iocxml.bean.UserDao;
import com.atguigu.spring6.iocxml.bean.UserDaoImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author liming
 * @Date 2023/9/16 22:33
 **/
public class testUserDao {
    //根据接口类型，得到实现类的对象(一个接口只能有一个实现类[可以])
    @Test
    public void testUserDaoObject(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //根据类型(根据id肯定能得到，这个我们就不测了)获取接口对应的bean
        //User user = (User) context.getBean(UserDaoImpl.class);   //这个肯定能得到,就不测了
        UserDao userDao = context.getBean(UserDao.class);    //我们要测试根据接口能不能获取到实现类
        System.out.println("根据接口类型获取的bean:====>" + userDao);
        userDao.run();
    }
}
