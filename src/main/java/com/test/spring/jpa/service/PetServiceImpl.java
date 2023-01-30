package com.test.spring.jpa.service;

import com.test.spring.jpa.entity.Employee;
import com.test.spring.jpa.entity.Pet;
import com.test.spring.jpa.repository.EmployeeRepository;
import com.test.spring.jpa.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    PetRepository petRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Pet create(Pet pet, int employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        pet.setEmployee(employee);
        return petRepository.save(pet);
    }

    @Override
    public List<Pet> readAll() {
        return new ArrayList<>(petRepository.findAll());
    }

    @Override
    public Pet read(int id) {
        return petRepository.findById(id).get();
    }

    @Override
    public Pet updatePetById(Pet pet, int id) {
        if (petRepository.existsById(id)) {
            Pet pet1 = petRepository.findById(id).get();
            pet1.setId(pet.getId());
            pet1.setView(pet.getView());
            return petRepository.save(pet1);
        }
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        if (petRepository.existsById(id)) {
            petRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
