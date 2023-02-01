package com.test.spring.jpa.service;

import com.test.spring.jpa.entity.Employee;
import com.test.spring.jpa.entity.Pet;
import com.test.spring.jpa.entity.Phone;
import com.test.spring.jpa.repository.EmployeeRepository;
import com.test.spring.jpa.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    PhoneRepository phoneRepository;

    @Override
    public Phone create(Phone phone, int employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        List<Phone> phones = new ArrayList<>();
        phones.add(phone);
        employee.setPhones(phones);
        return phoneRepository.save(phone);
    }

    @Override
    public List<Phone> readAll() {
        return new ArrayList<>(phoneRepository.findAll());
    }

    @Override
    public Phone read(int id) {
        return phoneRepository.findById(id).get();
    }

    @Override
    public Phone updatePhoneById(Phone phone, int id) {
        if (phoneRepository.existsById(id)) {
            Phone phone1 = phoneRepository.findById(id).get();
            phone1.setId(phone.getId());
            phone1.setNumber(phone.getNumber());
            return phoneRepository.save(phone1);
        }
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        if (phoneRepository.existsById(id)) {
            phoneRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
