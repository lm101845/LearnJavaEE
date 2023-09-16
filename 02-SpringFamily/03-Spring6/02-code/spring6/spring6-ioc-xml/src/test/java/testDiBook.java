import com.atguigu.spring6.iocxml.di.Book;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author liming
 * @Date 2023/9/16 23:03
 **/
public class testDiBook {
    //1.测试setter方法进行注入(给属性赋值)
    @Test
    public void testSetter(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }

    //1.测试构造方法进行注入(给属性赋值)
    @Test
    public void testConstructor(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");
        //写法1：
        //Book book = (Book) context.getBean("bookConstructor");
        //写法2：
        Book book = context.getBean("bookConstructor", Book.class);
        System.out.println(book);
    }
}
