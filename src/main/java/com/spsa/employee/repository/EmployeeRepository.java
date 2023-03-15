package com.spsa.employee.repository;

import com.spsa.employee.entity.EmployeeEntity;
import com.spsa.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
    @Modifying
    @Query(value = "DELETE FROM EmployeeEntity e WHERE e.id = :id")
    void deleteByUUID(@Param("id") String id);

    @Query(value = "SELECT e FROM EmployeeEntity e WHERE e.id=?1")
    EmployeeEntity findByUUId(String id);
}
