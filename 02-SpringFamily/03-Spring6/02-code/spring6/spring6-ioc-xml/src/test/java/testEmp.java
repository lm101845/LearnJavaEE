import com.atguigu.spring6.iocxml.dimap.Student;
import com.atguigu.spring6.iocxml.ditest.Dept;
import com.atguigu.spring6.iocxml.ditest.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author liming
 * @Date 2023/9/17 15:51
 **/
public class testEmp {
    //测试从员工中注入部门(对象)属性
    //外部bean测试
    @Test
    public void testEmpOuter(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-ditest.xml");
        //员工对象
        Emp emp = context.getBean("emp", Emp.class);
        emp.work();
    }

    //内部bean测试
    @Test
    public void testEmpInner(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-ditest.xml");
        Emp emp = context.getBean("emp2", Emp.class);
        emp.work();
    }

    //级联赋值
    @Test
    public void testEmpJilian(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-ditest.xml");
        Emp emp = context.getBean("emp3", Emp.class);
        emp.work();
    }

    //数组赋值
    @Test
    public void testEmpArray(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-diarray.xml");
        Emp emp = context.getBean("emp", Emp.class);
        emp.work();
    }

    //集合赋值(list集合)
    @Test
    public void testEmpList(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-dilist.xml");
        Dept dept = context.getBean("dept", Dept.class);
        dept.info();
    }

    //集合赋值(map集合)
    @Test
    public void testEmpMap(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-dimap.xml");
        Student student = context.getBean("student", Student.class);
        student.run();
    }

    //集合赋值(引用集合)
    @Test
    public void testEmpYinYong(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-diref.xml");
        Student student = context.getBean("student", Student.class);
        student.run();
    }

    //p命名空间
    @Test
    public void testEmpP(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-diref.xml");
        Student student = context.getBean("studentp", Student.class);
        student.run();
    }
}
