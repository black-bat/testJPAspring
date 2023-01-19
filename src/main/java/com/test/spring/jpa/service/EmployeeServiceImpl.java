package com.test.spring.jpa.service;

import com.test.spring.jpa.entity.Employee;
import com.test.spring.jpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final AtomicInteger EMPLOYEE_ID_HOLDER = new AtomicInteger();

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void create(Employee employee) {
        final int employeeId = EMPLOYEE_ID_HOLDER.incrementAndGet();
        employee.setId(employeeId);
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> readAll() {
        return new ArrayList<>(employeeRepository.findAll());
    }
    @Override
    public List<Employee> readByFirstname(String str) {
        return new ArrayList<>(employeeRepository.findByFirstName(str));
    }
    @Override
    public Employee read(int id) {
        return employeeRepository.findById(id).get();
    }
    @Override
    public boolean updateEmployeeById(Employee employee, int id) {
        if (employeeRepository.existsById(id)) {
            Employee employee1 = employeeRepository.getById(id);
            employee1.setFirstName(employee.getFirstName());
            employee1.setLastName(employee.getLastName());
            employee1.setGender(employee.getGender());
            employee1.setEmail(employee.getEmail());
            employee1.setDateBirth(employee.getDateBirth());
            employeeRepository.save(employee1);
            return true;
        }
        return false;
    }
    @Override
    public boolean deleteById(int id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
