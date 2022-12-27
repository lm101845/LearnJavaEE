package com.atguigu.spring.test;

import com.atguigu.spring.pojo.Clazz;
import com.atguigu.spring.pojo.Person;
import com.atguigu.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author liming
 * @Date 2022/12/24 23:14
 **/
public class IOCByXMLTest {
    @Test
    public void testDI(){
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //Student student = ioc.getBean("studentTwo", Student.class);
        //Student student = ioc.getBean("studentThree", Student.class);
        //Student student = ioc.getBean("studentFour", Student.class);
        Student student = ioc.getBean("studentFive", Student.class);
        //System.out.println(student.getGender().toString());
        //如果是String,则不会报错，如果是null,是空指针，报错。
        System.out.println(student);

        //Clazz clazz = ioc.getBean("clazzInner", Clazz.class);
        //System.out.println(clazz);
        //报错：NoSuchBeanDefinitionException，内部bean无法通过IOC容器直接获取，只能在内部使用
    }

    /**
     * 获取bean的三种方式：
     * 1、根据bean的id获取
     * 2、根据bean的类型获取
     * 注意：根据类型获取bean时，要求IOC容器中有且只有一个类型匹配的bean
     * 若没有任何一个类型匹配的bean，此时抛出异常：NoSuchBeanDefinitionException
     * 若有多个类型匹配的bean，此时抛出异常：NoUniqueBeanDefinitionException
     * 3、根据bean的id和类型获取
     * 结论：
     * 根据类型来获取bean时，在满足bean唯一性的前提下
     * 其实只是看：『对象 instanceof 指定的类型』的返回结果
     * 只要返回的是true就可以认定为和类型匹配，能够获取到。
     * 即通过bean的类型、bean所继承的类的类型、bean所实现的接口的类型都可以获取bean
     */
    @Test
    public void testIOC(){
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //获取bean(有3种方式)
        //方式1：这种还要强转
        //Student studentOne = (Student) ioc.getBean("studentOne");
        //方式2：不能写多个bean
        //Student student = ioc.getBean(Student.class);
        //方式3：常用的是这种,它可以写多个bean
        //Student student = ioc.getBean("studentOne", Student.class);
        //Person student = ioc.getBean(Student.class);
        Person person = ioc.getBean(Person.class);
        /**
         * 这样写是没有问题的，这个并不是通过Person类型获取的一个bean,而是当前通过Student类型获取了bean之后，
         * 把我们获取的对象，通过向上转型赋值给了它的接口对象
         * 疑问：如果一个接口有多个实现类，这些实现类都配置了 bean，根据接口类型可以获取 bean 吗？
         * 回答：不行，因为bean不唯一
         */
        System.out.println(person);
    }
}
