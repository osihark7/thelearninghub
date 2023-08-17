package com.dreamsathis.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamsathis.entity.Department;
import com.dreamsathis.entity.Employee;
import com.dreamsathis.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
    private  EmployeeRepository employeeRepository;

    public Map<Department, List<Employee>> getTop2SalariesByDepartment() {
        List<Employee> employees = employeeRepository.findAll();
        Map<Department, List<Employee>> top2SalariesByDepartment = new HashMap<>();

        for (Employee employee : employees) {
            Department department = employee.getDepartment();
           
            top2SalariesByDepartment.computeIfAbsent(department, k -> new ArrayList<>());
            List<Employee> departmentEmployees = top2SalariesByDepartment.get(department);
          
            if (departmentEmployees.size() < 2) {
                departmentEmployees.add(employee);
            } else {
                Employee lowestTop2SalaryEmployee = departmentEmployees.get(1);
                if (employee.getSalary() > lowestTop2SalaryEmployee.getSalary()) {
                    departmentEmployees.remove(lowestTop2SalaryEmployee);
                    departmentEmployees.add(employee);
                }
            }
        }
        return top2SalariesByDepartment;
    }

}
