package com.dreamsathis.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dreamsathis.entity.Department;
import com.dreamsathis.entity.Employee;
import com.dreamsathis.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
 
    @GetMapping("/top2salaries")
    public Map<Department, List<Employee>> getTop2SalariesByDepartment() {
        return employeeService.getTop2SalariesByDepartment();
    }
}
