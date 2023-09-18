package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.DynamicSQLMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author liming
 * @Date 2022/12/22 19:40
 **/
public class DynamicMapperTest {
    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        //Emp emp = new Emp(null, "张三", 20, "男");
        //Emp emp = new Emp(null, "", 20, "男");
        Emp emp = new Emp(null, "张三", 20, "");
        List<Emp> list = mapper.getEmpByCondition(emp);
        list.forEach(System.out::println);
        //Emp{empId=1, empName='张三', age=20, gender='男'}
    }

    @Test
    public void testGetEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        //Emp emp = new Emp(null, "张三", 20, "男");
        //Emp emp = new Emp(null, "", 20, "男");
        Emp emp = new Emp(null, "张三", 20, "");
        List<Emp> list = mapper.getEmpByChoose(emp);
        list.forEach(System.out::println);
        //Emp{empId=1, empName='张三', age=20, gender='男'}
        //select * from t_emp WHERE emp_name = ?,后面的age都不判断了
    }

    @Test
    public void testGetInsertMoreEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null, "小明", 8, "男");
        Emp emp2 = new Emp(null, "小光", 9, "男");
        Emp emp3 = new Emp(null, "小红", 10, "男");
        List<Emp> list = Arrays.asList(emp1, emp2, emp3);
        mapper.insertMoreEmp(list);
    }

    @Test
    public void testDeleteMoreEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Integer[] empIds = new Integer[]{6,7};
        mapper.deleteMoreEmp(empIds);
    }
}
