package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author liming
 * @Date 2022/12/23 15:02
 **/
public class PageTest {
    @Test
    public void testPage(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //查询功能之前开启分页功能(本身是一个拦截器)
        Page<Object> page = PageHelper.startPage(1, 4);
        //访问第1页，每页展示4条
        //这个page对象里面只有一部分数据
        //System.out.println(page);
        //查询功能之后可以获取分页相关的所有数据
        List<Emp> list = mapper.selectByExample(null);
        //list.forEach(System.out::println);
        PageInfo<Emp> pageInfo = new PageInfo<>(list,5);
        System.out.println(pageInfo);
        /**
         * PageInfo{
         * pageNum=1, pageSize=4, size=4,
         * startRow=1,endRow=4, total=28,
         * pages=7,
         * list=Page{count=true, pageNum=1, pageSize=4, startRow=0, endRow=4,
         * total=28, pages=7, reasonable=false, pageSizeZero=false}
         * [Emp{empId=1, empName='小黑', age=20, gender='女', deptId=1},
         * Emp{empId=2, empName='李四', age=22, gender='男', deptId=2},
         * Emp{empId=3, empName='王五', age=23, gender='男', deptId=3},
         * Emp{empId=4, empName='赵六', age=24, gender='男', deptId=1}],
         * prePage=0, nextPage=2, isFirstPage=true, isLastPage=false,
         * hasPreviousPage=false, hasNextPage=true, navigatePages=5,
         * navigateFirstPage=1, navigateLastPage=5, navigatepageNums=[1, 2, 3, 4, 5]
         * }
         */
    }
}
