package com.spsa.employee.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data@Table(name = "employee")
public class EmployeeEntity {
    @Id
    private String id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;

}
