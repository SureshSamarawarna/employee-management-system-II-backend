package com.spsa.employee.repository;

import com.spsa.employee.entity.EmployeeEntity;
import com.spsa.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
