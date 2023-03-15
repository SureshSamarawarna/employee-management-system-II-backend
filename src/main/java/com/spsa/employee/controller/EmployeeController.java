package com.spsa.employee.controller;

import com.spsa.employee.model.Employee;
import com.spsa.employee.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        employeeService.createEmployee(employee);
        return employee;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeByUUID(@PathVariable String id){
    return employeeService.getEmployeeByUUID(id);


    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;

    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable String id){
        boolean deleted = false;
        deleted = employeeService.deleteEmployee(id);
        Map<String, Boolean> map = new LinkedHashMap<>();
        map.put("deleted" ,deleted);
        ResponseEntity<Map<String, Boolean>> ok = ResponseEntity.ok(map);
        return ok;
    }

    
}
