/**
 * @Author liming
 * @Date 2023/9/15 20:45
 **/
import com.atguigu.spring6.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;

public class TestUser {
    @Test
    public void testUserObject(){
        //加载spring配置文件，对象创建(底层做了一个xml文件中的bean标签)
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //获取创建的对象
        User user = (User)context.getBean("user");
        System.out.println("1:" + user);
        //使用对象调用方法进行测试
        System.out.println("2:");
        user.add();

        //手动写日志
        logger.info("#######################执行调用成功了");
    }

    //反射创建对象
    @Test
    public void testUserObject1() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取类Class对象
        Class<?> clazz = Class.forName("com.atguigu.spring6.User");
        //调用方法创建对象
        //Object o = clazz.newInstance();   //过时了
        User user = (User)clazz.getDeclaredConstructor().newInstance();
        System.out.println(user + "经过反射创建的实例");
        //经过反射创建的对象，最终会保存在容器里面
    }

    //创建对象
    private Logger logger = LoggerFactory.getLogger(TestUser.class);

}
