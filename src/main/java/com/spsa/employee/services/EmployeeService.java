package com.spsa.employee.services;

import com.spsa.employee.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();

    boolean deleteEmployee(String id);

    Employee getEmployeeByUUID(String id);
}
