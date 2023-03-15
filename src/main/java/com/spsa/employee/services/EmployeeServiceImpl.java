package com.spsa.employee.services;

import com.spsa.employee.exception.ResourceNotFoundException;
import com.spsa.employee.entity.EmployeeEntity;
import com.spsa.employee.model.Employee;
import com.spsa.employee.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService{


    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        System.out.println(employee);
        employee.setId(String.valueOf(UUID.randomUUID()));
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(employee.getId());
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());
        employeeEntity.setEmail(employee.getEmail());
        System.out.println(employeeEntity);

        employeeRepository.save(employeeEntity);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<Employee> employees = employeeEntities.stream()
                .map(emp -> new Employee(
                        emp.getId(),
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getEmail()))
                .collect(Collectors.toList());
        return employees;

    }

    @Override
    public boolean deleteEmployee(String id) {
        EmployeeEntity employeeEntity = employeeRepository.findByUUId(id);
        if (employeeEntity != null){
            employeeRepository.deleteByUUID(id);
        }else{
            throw new ResourceNotFoundException("Can't find employee id.");

        }
        return true;

    }

    @Override
    public Employee getEmployeeByUUID(String id) {
        EmployeeEntity employeeEn = employeeRepository.findByUUId(id);
        Employee employee = new Employee();
        employee.setId(employeeEn.getId());
        employee.setFirstName(employeeEn.getFirstName());
        employee.setLastName(employeeEn.getLastName());
        employee.setEmail(employeeEn.getEmail());
        return employee;
    }
}
