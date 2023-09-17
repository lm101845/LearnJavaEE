package com.atguigu.spring6.iocxml.ditest;

import java.util.Arrays;

/**
 * @Author liming
 * @Date 2023/9/17 15:38
 **/

//员工类
public class Emp {
    //对象类型属性：员工属于某一个部门
    private Dept dept;
    //员工名称
    private String ename;
    //员工年龄
    private Integer age;
    //员工爱好
    private String[] hobby;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public void work(){
        System.out.println("员工" + ename + "在工作" + "他今年" + age + "岁了");
        dept.info();
        System.out.println(Arrays.toString(hobby));
    }
}
