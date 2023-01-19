package com.test.spring.jpa.controller;

import com.test.spring.jpa.entity.Employee;
import com.test.spring.jpa.entity.Pet;
import com.test.spring.jpa.model.EmployeeModel;
import com.test.spring.jpa.model.PetModel;
import com.test.spring.jpa.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    PetService petService;

    @GetMapping(value = "/pets")
    public ResponseEntity<List<PetModel>> read() {
        final List<Pet> pets = petService.readAll();
        return pets != null && !pets.isEmpty()
                ? new ResponseEntity<>(PetModel.readAllModel(pets), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/pets/{id}")
    public PetModel read(@PathVariable(name = "id") int id) {
        final Pet pet = petService.read(id);
        return PetModel.toModel(pet);
    }

    @PostMapping
    public ResponseEntity createPet(@RequestBody Pet pet,
                                    @RequestParam int id) {
        try {
            return ResponseEntity.ok(petService.create(pet, id));
        } catch ( Exception e ) {

            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping
    public ResponseEntity completePet(@RequestBody Pet pet,
                                      @RequestParam int id) {
        try {
            return ResponseEntity.ok(petService.updatePetById(pet, id));
        } catch ( Exception e ) {

            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping(value = "/pets/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = petService.deleteById(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}

