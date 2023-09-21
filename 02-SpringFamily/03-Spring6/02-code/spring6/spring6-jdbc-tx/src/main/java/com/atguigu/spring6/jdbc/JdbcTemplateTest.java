package com.atguigu.spring6.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

/**
 * @Author liming
 * @Date 2023/9/21 15:58
 **/

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //添加 修改 删除操作(都是调用同一个方法实现的)
    @Test
    public void testAdd() {
        //1.添加操作
        //第一步：编写SQL语句
        String sql = "INSERT INTO t_emp VALUES(NULL,?,?,?)";
        //第二步：调用jdbcTemplate的方法，传入相关参数
        //写法1：
        int rows = jdbcTemplate.update(sql, "admin", 18, "女");
        //写法2：
        //Object[] params = {"test", 20, "男"};
        //int rows = jdbcTemplate.update(sql, params);
        System.out.println(rows);
    }

    @Test
    public void testUpdate() {
        String sql = "update t_emp set sex = ? where id = ?";
        int rows = jdbcTemplate.update(sql, "男", 2);
        System.out.println(rows);
    }

    @Test
    public void testDelete() {
        String sql = "delete from t_emp where id = ?";
        int rows = jdbcTemplate.update(sql, 3);
        System.out.println(rows);
    }

    //============================================================
    //查询:返回对象
    @Test
    public void testSelectObject() {
        //写法1：
        //String sql = "select * from t_emp where id = ?";
        //Emp empResult = jdbcTemplate.queryForObject(sql, (resultSet, rowNum) -> {
        //    //这样写也太麻烦了
        //    Emp emp = new Emp();
        //    emp.setId(resultSet.getInt("id"));
        //    emp.setName(resultSet.getString("name"));
        //    emp.setAge(resultSet.getInt("age"));
        //    emp.setSex(resultSet.getString("sex"));
        //    return emp;
        //}, 1);
        //System.out.println(empResult);

        //写法2：底层就是方法1
        String sql = "select * from t_emp where id = ?";
        Emp emp = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class),2);
        System.out.println(emp);
    }

    //查询：返回List集合
    @Test
    public void testSelectList(){
        String sql = "select * from t_emp";
        List<Emp> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        System.out.println(list);
    }

    //查询：返回单个值(比如count)
    @Test
    public void testSelectValue(){
        String sql = "select count(*) from t_emp";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        //第2个参数是返回类型的class
        System.out.println(count);
    }

}
