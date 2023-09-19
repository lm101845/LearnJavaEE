package com.atguigu.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author liming
 * @Date 2023/9/19 22:23
 **/
public class TestCar {
    //1.获取class对象(即字节码文件)的多种方式
    @Test
    public void test01() throws Exception {
        //1.类名.class
        Class<Car> clazz1 = Car.class;

        //2.对象.getClass()
        Class clazz2 = new Car().getClass();

        //3.Class.forName("全路径")
        Class clazz3 = Class.forName("com.atguigu.reflect.Car");

        //实例化
        Car car = (Car) clazz3.getDeclaredConstructor().newInstance();
        System.out.println(car);
    }

    //2.获取构造方法
    @Test
    public void test02() throws Exception {
        Class<Car> clazz = Car.class;
        //获取类中的所有构造方法
        //getConstructors用于获取所有【public】的构造方法
        Constructor[] constructors1 = clazz.getConstructors();
        for (Constructor c1 : constructors1) {
            System.out.println("方法名称1：" + c1.getName() + "==>参数个数：" + c1.getParameterCount());
        }

        System.out.println("====================================");

        //getDeclaredConstructors用于获取所有的构造方法(不仅仅是public)
        Constructor[] constructors2 = clazz.getDeclaredConstructors();
        for (Constructor c2 : constructors2) {
            System.out.println("方法名称2：" + c2.getName() + "==>参数个数：" + c2.getParameterCount());
        }

        System.out.println("====================================");
        //指定有参构造来创建对象(默认是用无参构造创建的)
        //1.适用于构造方法是public的
        Constructor<Car> c3 = clazz.getConstructor(String.class, int.class, String.class);
        Car car1 = c3.newInstance("奔驰", 10, "黑色");
        System.out.println(car1);
        System.out.println(car1.getName());

        System.out.println("========================================");

        //2.适用于构造是private的
        Constructor<Car> c4 = clazz.getDeclaredConstructor(String.class, int.class);
        //必须要先设置一下，才能访问私有的构造函数
        c4.setAccessible(true);
        Car car2 = c4.newInstance("宝马", 5);
        System.out.println(car2);
        System.out.println(car2.getName());
    }


    //3.通过反射获取类中的属性
    @Test
    public void test03() throws Exception {
        Class<Car> clazz = Car.class;
        Car car = clazz.getConstructor().newInstance();
        System.out.println(car.getName() + "==>刚开始创建car的name");
        //1.获取public属性
        //Field[] fields = clazz.getFields();

        //2.获取所有属性(包含私有属性)
        //getDeclaredFields只是表示获取这个类自身声明的属性，并不是获取所有属性，其中就不包括从父类继承的属性，这里说的不严谨
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            //System.out.println("刚开始field==>" + field.getName());
            //向属性中设置值
            if ("name".equals(field.getName())) {
                field.setAccessible(true);
                field.set(car, "五菱宏光");
            }
            //System.out.println("设置值之后的field==>" + field.getName());
            System.out.println("设置值之后的car" + car);
        }

    }


    //4.通过反射获取类中的所有方法
    @Test
    public void test04() throws Exception {
        Car car = new Car("奇瑞", 10, "白色");
        Class clazz = car.getClass();
        //1.public方法
        Method[] methods = clazz.getMethods();
        for(Method m1:methods){
            System.out.println(m1.getName());
            //执行某个方法
            if("toString".equals(m1.getName())){
                String invoke = (String) m1.invoke(car);
                System.out.println("toString方法执行" + invoke);
            }
        }

        System.out.println("============分割线=================");

        //2.private方法
        Method[] methodsAll = clazz.getDeclaredMethods();
        for(Method m2:methodsAll){
            System.out.println(m2.getName());
            //执行某个方法——拿一个私有方法测试
            if("run".equals(m2.getName())){
                m2.setAccessible(true);   //必须要加这个，因为run是private私有的
                m2.invoke(car);
            }
        }

    }
}
