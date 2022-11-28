package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author liming
 * @Date 2022/11/28 19:43
 **/
public class MyBatisTest {
    /**
     * 为什么这个Test文件左边没有绿标，执行不了啊？？？？？？？？？？？？？
     */
    @Test
    public void testInsert() throws IOException {
        //1.获取核心配置文件的输入流(读,你把你自己想象成内存，占在内存的角度)
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //2.获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //3.获取SqlSession对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //4.获取SQL的会话对象SqlSession,是MyBatis提供的操作数据库的对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //5.获取UserMapper的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //代理模式：相当于根据这个接口，直接new了一个对象，调用了这个接口的方法给我们用
        /**
         * 具体过程：
         * 通过UserMapper接口的全类名，找到我们当前的映射文件
         * 再通过我们要调用的方法，来找到映射文件当中的SQL语句来执行并将结果返回
         */
        //调用mapper接口中的方法，实现添加用户信息的功能
        int result = mapper.insertUser();
        System.out.println("结果：" + result);
        sqlSession.commit();
        //提交事物
        sqlSession.close();
        //sqlSession是一个会话，用完了要关掉
    }
}
