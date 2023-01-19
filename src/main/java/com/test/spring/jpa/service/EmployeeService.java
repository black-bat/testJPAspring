package com.test.spring.jpa.service;

import com.test.spring.jpa.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeService {

    void create(Employee employee);

    List<Employee> readAll();

    List<Employee> readByFirstname(String str);

    Employee read(int id);

    boolean updateEmployeeById(Employee employee, int id);

    boolean deleteById(int id);
}
