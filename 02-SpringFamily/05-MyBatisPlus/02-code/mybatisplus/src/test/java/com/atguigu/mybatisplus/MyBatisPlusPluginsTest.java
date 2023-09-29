package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.ProductMapper;
import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.Product;
import com.atguigu.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author liming
 * @Date 2023/9/29 11:41
 **/

@SpringBootTest
public class MyBatisPlusPluginsTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;
    //===============================测试分页==========================================
    @Test
    public void testPage(){
        Page<User> page = new Page<User>(1,3);
        //访问第一页，每页显示3条数据
        //把page对象传进去，到时候会把结果封装到传入的page对象里
        userMapper.selectPage(page,null);
        //System.out.println(page);
        System.out.println(page.getRecords());
        System.out.println(page.getPages());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }

    @Test
    public void testPageVO(){
        Page<User> page = new Page<>();
        userMapper.selectPageVO(page,20);
        System.out.println("page.getRecords："+page.getRecords());
        System.out.println("page.getPages："+page.getPages());
        System.out.println("page.getTotal："+page.getTotal());
        System.out.println("page.hasNext:"+page.hasNext());
        System.out.println("page.hasPrevious:"+page.hasPrevious());
    }

    //===============================测试乐观锁/悲观锁==========================================
    @Test
    public void testProduct01(){
        //小李查询商品价格
        Product productLi = productMapper.selectById(1L);
        System.out.println("小李查询的商品价格：" + productLi.getPrice());
        //小王查询商品价格
        Product productWang = productMapper.selectById(1L);
        System.out.println("小王查询的商品价格：" + productWang.getPrice());

        //小李将商品价格+50
        productLi.setPrice(productLi.getPrice() + 50);
        productMapper.updateById(productLi);

        //小王将商品价格-30
        productWang.setPrice(productWang.getPrice() -30);
        int result = productMapper.updateById(productWang);
        if(result == 0){
            //操作失败，重试(重新获取商品信息，重新查询)
            Product productNew = productMapper.selectById(1L);
            productNew.setPrice(productNew.getPrice() - 30);
            productMapper.updateById(productNew);
        }

        //老板查询
        Product productBoss = productMapper.selectById(1L);
        System.out.println("老板查询的商品价格：" + productBoss.getPrice());
    }
}
