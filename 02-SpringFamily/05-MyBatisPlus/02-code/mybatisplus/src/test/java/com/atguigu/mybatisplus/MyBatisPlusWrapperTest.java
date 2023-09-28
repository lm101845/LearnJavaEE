package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.apache.ibatis.annotations.Update;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @Author liming
 * @Date 2023/9/27 11:41
 **/

@SpringBootTest
public class MyBatisPlusWrapperTest {
    @Autowired
    private UserMapper userMapper;
    //==================================QueryWrapper============================================
    //组装查询条件
    @Test
    public void test01() {
        //查询用户名包含a，年龄在20-30之间，邮箱信息不为null的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //column写的不是实体类中的属性名，而是数据库中的字段名
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND
        // (user_name LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
        queryWrapper
                .like("user_name", "a")
                .between("age", 20, 30)
                .isNotNull("email");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }


    //组装排序条件
    @Test
    public void test02() {
        //查询用户信息，按年龄降序排序，若年龄相同，按id升序排序
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 ORDER BY age DESC,uid ASC
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .orderByDesc("age")
                .orderByAsc("uid");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    //组装删除条件
    @Test
    public void test03() {
        //删除(逻辑删除)邮箱地址为null的用户信息
        //UPDATE t_user SET is_deleted=1 WHERE is_deleted=0 AND (email IS NULL)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int result = userMapper.delete(queryWrapper);
        System.out.println("result:" + result);
    }

    //组装修改功能
    @Test
    public void test04(){
        //将(年龄大于20并且用户名中含有a)或者邮箱为null的用户信息修改
        //queryWrapper用于封装修改条件的，先将数据匹配到，然后再进行修改
        //UPDATE t_user SET user_name=?, email=? WHERE is_deleted=0 AND (age > ? AND user_name LIKE ? OR email IS NULL)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .gt("age",20)
                .like("user_name","a")
                .or()
                //这里要用or方法进行连接(以前默认都是and方法，所以不用写)
                .isNull("email");
        User user = new User();
        user.setName("修改为小明");
        user.setEmail("修改为105@qq.com");
        int result = userMapper.update(user, queryWrapper);
        System.out.println("result:" + result);
    }

    //优先级
    @Test
    public void test05(){
        //将用户名中包含有a并且(年龄大于20或邮箱为null)的用户信息修改
        //UPDATE t_user SET user_name=?, email=? WHERE is_deleted=0 AND (age > ? AND user_name LIKE ? OR email IS NULL)
        //比较之前：===>将(年龄大于20并且用户名中含有a)或者邮箱为null的用户信息修改
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .like("user_name","a")
                .and(i->i.gt("age",20).or().isNull("email"));
                //错误写法
                //.like("user_name","a")
                //.gt("age",20)
                //.or()
                //.isNull("email");
        User user = new User();
        user.setName("修改为小红");
        user.setEmail("修改为185@qq.com");
        int result = userMapper.update(user, queryWrapper);
        System.out.println("result:" + result);
    }

    //组装select子句
    @Test
    public void test06(){
        //查询用户的用户名、年龄、邮箱信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("user_name","age","email");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    //组装子查询
    @Test
    public void test07(){
        //查询id小于等于4的用户信息
        // SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (uid IN (select uid from t_user where uid <= 4))
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("uid","select uid from t_user where uid <= 4");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    //==================================updateWrapper============================================
    @Test
    public void test08(){
        //将用户名中包含有a并且(年龄大于20或邮箱为null)的用户信息修改
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper
                .like("user_name","a")
                .and(i->i.gt("age",20).or().isNull("email"));
        updateWrapper
                .set("user_name","小黑")
                .set("email","abc@qq.com");
        //这里我们不是用实体类对象设置的(是使用.set设置的)，所以第一个参数为null
        userMapper.update(null,updateWrapper);
    }

    //==================================Condition============================================
    @Test
    public void test09(){
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (age >= ? AND age <= ?)
        String username = "";
        Integer ageBegin = 20;
        Integer ageEnd = 30;

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //isNotBlank:判断某个字符串是否不为空字符串，不为Null，不为空白符
        if(StringUtils.isNotBlank(username)){
            queryWrapper.like("user_name",username);
        }
        if(ageBegin != null){
            queryWrapper.ge("age",ageBegin);
        }
        if(ageEnd != null){
            queryWrapper.le("age",ageEnd);
        }
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test10(){
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (user_name LIKE ? AND age <= ?)
        String username = "a";
        Integer ageBegin = null;
        Integer ageEnd = 30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //这种适合前面页面的条件筛选查询，传递到后端来处理
        queryWrapper
                .like(StringUtils.isNotBlank(username),"user_name",username)
                .ge(ageBegin != null,"age",ageBegin)
                .le(ageEnd != null,"age",ageEnd);
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    //==================================LambdaQueryWrapper============================================
    @Test
    public void test11(){
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (user_name LIKE ? AND age <= ?)
        String username = "a";
        Integer ageBegin = null;
        Integer ageEnd = 30;
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .like(StringUtils.isNotBlank(username),User::getName,username)
                .ge(ageBegin != null,User::getAge,ageBegin)
                .le(ageEnd != null,User::getAge,ageEnd);
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    //==================================LambdaUpdateWrapper============================================
    @Test
    public void test12(){
        //将用户名中包含有a并且(年龄大于20或邮箱为null)的用户信息修改
        //UPDATE t_user SET user_name=?,email=? WHERE is_deleted=0 AND (age LIKE ? AND (age > ? OR email IS NULL))
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper
                .like(User::getName,"a")
                .and(i->i.gt(User::getAge,20).or().isNull(User::getEmail));
        updateWrapper.set(User::getName,"小白").set(User::getEmail,"xiaobai@wangwang.com");
        int result = userMapper.update(null, updateWrapper);
        System.out.println("result:" + result);
    }
}
