package com.test.spring.jpa.service;

import com.test.spring.jpa.entity.Employee;
import com.test.spring.jpa.entity.Pet;

import java.util.List;

public interface PetService {

    Pet create(Pet pet,int employeeId);

    List<Pet> readAll();

    Pet read(int id);

    boolean updatePetById(Pet pet, int id);

    boolean deleteById(int id);
}
