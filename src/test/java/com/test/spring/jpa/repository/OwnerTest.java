package com.test.spring.jpa.repository;

import com.test.spring.jpa.entity.Employee;
//import com.test.spring.jpa.entity.Pet;
import org.hibernate.LazyInitializationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class OwnerTest {
//
//    @Autowired
//    PetRepository petRepository;
//
//    @Autowired
//    EmployeeRepository employeeRepository;
//
//    @Test
//    public void ownerTest() throws Exception {
//
//        List<Pet> pets = petRepository.findAllById(2);
//        Employee employee = pets.get(0).getEmployee();
//        employee.setLastName("Nan");
//        employeeRepository.save(employee);
//        System.out.println(employeeRepository.findAll());
//    }
//}
