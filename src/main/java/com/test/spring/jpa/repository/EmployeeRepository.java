package com.test.spring.jpa.repository;

import com.test.spring.jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByFirstName(String firstName);

    @Query("SELECT p FROM Employee p ORDER BY firstName")
    List<Employee> findAllEmployeeByFirstName();

}
