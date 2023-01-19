package com.test.spring.jpa.controller;

import com.test.spring.jpa.entity.Phone;
import com.test.spring.jpa.repository.EmployeeRepository;
import com.test.spring.jpa.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/phone")
@RestController
public class ControllerPhone {
    @Autowired
    PhoneRepository phoneRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping
    public Phone getPhone() {
        return phoneRepository.findById(1).get();
    }
}
