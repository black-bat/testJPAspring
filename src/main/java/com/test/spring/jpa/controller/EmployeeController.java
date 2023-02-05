package com.test.spring.jpa.controller;

import com.test.spring.jpa.entity.Employee;
import com.test.spring.jpa.exception.ResourceNotFoundException;
import com.test.spring.jpa.model.EmployeeModel;
import com.test.spring.jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value = "/employees")
    public ResponseEntity<EmployeeModel> create(@RequestBody Employee employee) {
        return new ResponseEntity<>(EmployeeModel.toModel(employeeService.create(employee)), HttpStatus.CREATED);
    }

    @GetMapping(value = "/employees")
    public ResponseEntity<List<EmployeeModel>> read() {
        final List<Employee> employees = employeeService.readAll();
        return employees != null && !employees.isEmpty()
                ? new ResponseEntity<>(EmployeeModel.readAllModel(employees), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/employees/name/{first_name}")
    public ResponseEntity<List<EmployeeModel>> readByFirstName(@PathVariable(name = "first_name") String str) {
        final List<Employee> employees = employeeService.readByFirstname(str);
        return employees != null && !employees.isEmpty()
                ? new ResponseEntity<>(EmployeeModel.readAllModel(employees), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/employees/{id}")
    public ResponseEntity<EmployeeModel> readById(@PathVariable(name = "id") int id) {
        final Employee employee = employeeService.read(id);
        return employee != null
                ? new ResponseEntity<>(EmployeeModel.toModel(employee), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/employees/{id}")
    public ResponseEntity<EmployeeModel> update(@PathVariable(name = "id") int id, @RequestBody Employee employee) {
        return new ResponseEntity<>(EmployeeModel.toModel(employeeService.updateEmployeeById(employee, id)), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/employees/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = employeeService.deleteById(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
