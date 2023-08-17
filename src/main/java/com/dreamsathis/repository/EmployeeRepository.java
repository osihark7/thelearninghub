package com.dreamsathis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dreamsathis.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE e.department.id = ?1 ORDER BY e.salary DESC")
    List<Employee> findTop3ByDepartmentOrderBySalaryDesc(Long departmentId);
}
