package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * @Author liming
 * @Date 2022/12/22 15:48
 **/
public interface DeptMapper {
    /**
     * 通过分步查询查询员工以及所对应的部门信息的第二步
     * 多(员工)对一(部门)
     * @return
     */
    Dept getEmpAndDeptByStepTwo(@Param("deptId")Integer deptId);

    /**
     * 查询部门以及部门中的员工信息
     * 一(部门)对多(员工)
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByDeptId(@Param("deptId")Integer deptId);

    /**
     * 通过分步查询查询部门以及部门中的员工信息的第一步
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByStepOne(@Param("deptId")Integer deptId);
}
