package com.test.spring.jpa.controller;

import com.test.spring.jpa.entity.Pet;
import com.test.spring.jpa.exception.ResourceNotFoundException;
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
    public ResponseEntity<List<PetModel>> readPets() {
        List<Pet> pets = petService.readAll();
        return pets != null && !pets.isEmpty()
                ? new ResponseEntity<>(PetModel.readAllModel(pets), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/pets/{id}")
    public ResponseEntity<PetModel> read(@PathVariable(name = "id") int id) {
        try {
            return new ResponseEntity<>(PetModel.toModel(petService.read(id)), HttpStatus.OK);
        } catch ( ResourceNotFoundException e ) {
            throw new ResourceNotFoundException("Not found Pet with id = " + id);
        }
    }

    @PostMapping
    public ResponseEntity<PetModel> createPet(@RequestBody Pet pet,
                                              @RequestParam int id) {
        PetModel petModel = PetModel.toModel(petService.create(pet, id));
        return new ResponseEntity(petModel, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PetModel> completePet(@RequestBody Pet pet,
                                                @RequestParam int id) {
        try {
            return new ResponseEntity<>(PetModel.toModel(petService.updatePetById(pet, id)), HttpStatus.OK);
        } catch ( Exception e ) {
            throw new ResourceNotFoundException("Not found Pet with id = " + id);
        }
    }

    @DeleteMapping(value = "/pets/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(name = "id") int id) {
        petService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

