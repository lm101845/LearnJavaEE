package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author liming
 * @Date 2023/9/23 14:10
 **/

//===================================Mapper CRUD 接口提供的方法=========================================
@SpringBootTest
public class MyBatisPlusTest {

    @Autowired
    private UserMapper userMapper;
    //报红线，其实没事

    @Test
    public void testSelectList(){
        //通过条件构造器查询一个list集合,若没有条件，则可以设置参数为null
        //写法1：
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);

        //写法2：
        //userMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    public void testSelectById(){
        //根据id查询用户信息
        //SELECT id,name,age,email FROM user WHERE id=?
        User user = userMapper.selectById(1L);
        System.out.println("user:" + user);
    }

    @Test
    public void testSelectBatchIds(){
        //根据多个id查询多个用户信息
        //SELECT id,name,age,email FROM user WHERE id IN ( ? , ? , ? )
        List<Long> list = Arrays.asList(1L, 2L, 3L);
        List<User> users = userMapper.selectBatchIds(list);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectByMap(){
        //根据map集合中的条件查询用户信息
        //SELECT id,name,age,email FROM user WHERE name = ? AND age = ?
        Map<String,Object> map = new HashMap<>();
        map.put("name","Jack");
        map.put("age",20);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    @Test
    public void testInsert(){
        //实现新增用户信息
        //INSERT INTO user(id,name,age,email) VALUES(?,?,?,?)
        User user = new User();
        user.setName("李白");
        user.setAge(52);
        user.setEmail("1018457683@qq.com");
        int result = userMapper.insert(user);
        System.out.println("result:" + result);
        System.out.println("id:" + user.getId());
        //id对象自动生成(mybatis-plus的id默认使用雪花算法生成的)
    }

    @Test
    public void testDeleteById(){
        //通过id删除用户信息
        //DELETE FROM user WHERE id=?
        int result = userMapper.deleteById(1706318635956424706L);
        System.out.println(result);
    }

    @Test
    public void testDeleteByMap(){
        //mybatis的底层就是通过map进行传参的
        //根据map集合中所设置的条件删除用户信息
        //条件是【并】的关系
        //DELETE FROM user WHERE name = ? AND age = ?  and！！并的关系
        HashMap<String , Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("age","23");
        int result = userMapper.deleteByMap(map);
        System.out.println(result);
    }

    @Test
    public void testDeleteBatchIds(){
        //通过多个id实现批量删除
        //DELETE FROM user WHERE id IN ( ? , ? , ? )
        List<Long> list = Arrays.asList(1L, 2L, 3L);
        int result = userMapper.deleteBatchIds(list);
        System.out.println(result);
    }

    @Test
    //注意修改不能加乐观锁
    public void testUpdate(){
        //根据id修改用户信息
        // UPDATE user SET name=?, email=? WHERE id=?
        User user = new User();
        user.setId(4L);
        user.setName("李四");
        user.setEmail("lisi@gmail.com");
        //如果传入的某个参数是null不会修改对应字段的
        //age没有设置，他也没有修改age字段，仍是之前的值
        int result = userMapper.updateById(user);
        System.out.println(result);
    }

    @Test
    public void testZidingyi(){
        //select id,name,age,email from user where id = ?
        Map<String, Object> map = userMapper.selectMapById(1L);
        System.out.println(map);
    }
}
