import com.atguigu.spring6.iocxml.scope.Orders;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author liming
 * @Date 2023/9/18 15:40
 **/
public class testOrders {
    @Test
    public void demo1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-scope.xml");
        Orders orders1 = context.getBean("orders", Orders.class);
        System.out.println(orders1);
        Orders orders2 = context.getBean("orders", Orders.class);
        System.out.println(orders2);
        System.out.println(orders1 == orders2);
    }
}
