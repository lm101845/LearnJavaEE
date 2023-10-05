package com.atguigu.boot3.crud.controller;


import com.atguigu.boot3.crud.entity.Employee;
import com.atguigu.boot3.crud.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lfy
 * @Description
 * @create 2023-04-28 16:41
 */
@Tag(name = "员工",description = "员工CRUD")
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Operation(summary = "单个查询",description = "按照id查询员工")
    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id") Long id){
        return employeeService.getEmployeeById(id);
    }

    @Operation(summary = "查询所有员工")
    @GetMapping("/emps")
    public List<Employee> getEmployee(){
        return employeeService.getEmployees();
    }

    @Operation(summary = "保存员工")
    @PostMapping("/emp")
    public String saveEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return "ok";
    }

    @Operation(summary = "删除员工",description = "按照id删除员工")
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return "ok";
    }
}
