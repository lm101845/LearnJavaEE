package com.atguigu.spring6.iocxml.ditest;

import java.util.Arrays;
import java.util.List;

/**
 * @Author liming
 * @Date 2023/9/17 15:37
 **/

//部门类
public class Dept {
    //一个部门有很多员工
    private List<Emp> empList;

    private String dname;

    public void info(){
        System.out.println("部门名称：" + dname);
        for (Emp emp:empList){
            System.out.println(emp.getEname() + "====》员工姓名");
            System.out.println(Arrays.toString(emp.getHobby()) + "====》员工爱好");
        }

    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "empList=" + empList +
                ", dname='" + dname + '\'' +
                '}';
    }
}
