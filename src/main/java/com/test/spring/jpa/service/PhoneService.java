package com.test.spring.jpa.service;

import com.test.spring.jpa.entity.Pet;
import com.test.spring.jpa.entity.Phone;

import java.util.List;

public interface PhoneService {
    Phone create(Phone phone, int employeeId);

    List<Phone> readAll();

    Phone read(int id);

    Phone updatePhoneById(Phone phone, int id);

    boolean deleteById(int id);

}
