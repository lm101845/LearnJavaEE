package com.atguigu.bean;

import com.atguigu.annotation.Bean;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author liming
 * @Date 2023/9/19 23:48
 **/
public class AnnotationApplicationContext implements ApplicationContext{
    //创建一个map集合，存放bean对象
    private  Map<Class,Object> beanFactory = new HashMap<>();
    private static String rootPath;

    //返回对象
    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }


    //创建有参构造，传递包路径，设置包扫描规则
    //当前包及其自子包，哪个类有@Bean注解，就把这个类通过反射进行实例化

    public AnnotationApplicationContext(String basePackage){
    //public static void pathdemo1(String basePackage){
        //com.atguigu
        try{
            //1.把.替换成\
            String packagePath = basePackage.replaceAll("\\.", "\\\\");
            //在字符串引号中\\表示一个\,第一个\是转义,第二个\是本意  因为\是特殊字符,正则表达还要把这个本意\转成真正的\,所以用\\转义 所以在引号内 4个\
            //2.获取包的绝对路径(最终编译后的路径!!)
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);
            while (urls.hasMoreElements()){
                URL url = urls.nextElement();
                String filePath = URLDecoder.decode(url.getFile(), "utf-8");
                System.out.println(filePath);
                //win不在意斜杠正反

                //获取包前面路径部分，进行字符串截取
                rootPath = filePath.substring(0,filePath.length()-packagePath.length());
                //包扫描
                loadBean(new File(filePath));
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //包扫描的过程，让bean进行实例化
    private  void loadBean(File file) throws Exception {
        //1.判断当前内容是否是文件夹
        if(file.isDirectory()){
            //2.获取文件夹里面的内容
            File[] childrenFiles = file.listFiles();
            //3.判断文件夹里面为空，直接返回
            if(childrenFiles == null || childrenFiles.length == 0){
                return;
            }
            //4.如果文件夹里面不为空，遍历文件夹里面所有内容
            for(File child:childrenFiles){
                //4.1遍历得到每个File对象，继续判断，如果还是文件夹，递归
                if(child.isDirectory()){
                    loadBean(child);
                }else{
                    //4.2遍历得到的File对象不是文件夹(是文件)
                    //4.3得到包路径 + 类名称部分-字符串截取
                    String pathWithClass = child.getAbsolutePath().substring(rootPath.length() - 1);
                    //System.out.println(pathWithClass + "pathWithClass");
                    //4.4判断当前文件类型是否是.class
                    if(pathWithClass.contains(".class")){
                        //4.5如果是.class类型，把路径\替换成.并且把.class去掉  类似com.atguigu.service.UserServiceImpl
                        String fullName = pathWithClass.replaceAll("\\\\", ".").replace(".class", "");
                        //4.6判断类上面是否有注解@Bean，如果有则实例化
                        //4.6.1获取类的class对象
                        Class<?> clazz = Class.forName(fullName);
                        //4.6.2判断不是接口，才进行实例化
                        if(!clazz.isInterface()){
                            //4.6.3判断类上面是否有注解
                            Bean annotation = clazz.getAnnotation(Bean.class);
                            if(annotation != null){
                                //4.6.4实例化
                                Object instance = clazz.getConstructor().newInstance();
                                //4.7把对象实例化之后,放到map集合beanFactory
                                //4.7.1 判断当前类如果有接口，让接口class作为map的key
                                if(clazz.getInterfaces().length > 0){
                                    beanFactory.put(clazz.getInterfaces()[0],instance);
                                    //如果同一个接口的实现类有多个，value会覆盖成最后一个实现类的instance
                                }else{
                                    //如果没有接口把自己的class当成key，实例对象当成value
                                    beanFactory.put(clazz,instance);
                                }
                            }
                        }

                    }
                }
            }
        }
    }

    //public static void main(String[] args) {
    //    //AnnotationApplicationContext context = new AnnotationApplicationContext("com.atguigu");
    //    //context.getBean()
    //    //pathdemo1("com.atguigu");
    //}
}
