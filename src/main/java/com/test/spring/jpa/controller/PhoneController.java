package com.test.spring.jpa.controller;

import com.test.spring.jpa.entity.Phone;
import com.test.spring.jpa.exception.ResourceNotFoundException;
import com.test.spring.jpa.model.PhoneModel;
import com.test.spring.jpa.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/phone")
@RestController
public class PhoneController {
    @Autowired
    PhoneService phoneService;

    @GetMapping(value = "/readAll")
    public ResponseEntity<List<PhoneModel>> read() {
        List<Phone> phones = phoneService.readAll();
        return phones != null && !phones.isEmpty()
                ? new ResponseEntity<>(PhoneModel.readAllModel(phones), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/phone/{id}")
    public ResponseEntity<PhoneModel> readById(@PathVariable(name = "id") int id) {
        try {
            return new ResponseEntity<>(PhoneModel.toModel(phoneService.read(id)), HttpStatus.OK);
        } catch ( ResourceNotFoundException e ) {
            throw new ResourceNotFoundException("Not found Phone with id = " + id);
        }
    }

    @PostMapping
    public ResponseEntity<PhoneModel> createPhone(@RequestBody Phone phone,
                                                  @RequestParam int id) {
        try {
            return new ResponseEntity(PhoneModel.toModel(phoneService.create(phone, id)), HttpStatus.OK);
        } catch ( ResourceNotFoundException e ) {
            throw new ResourceNotFoundException("Not found Phone with id = " + id);
        }
    }

    @PutMapping
    public ResponseEntity<PhoneModel> completePhone(@RequestBody Phone phone,
                                                    @RequestParam int id) {
        PhoneModel phoneModel = PhoneModel.toModel(phoneService.updatePhoneById(phone, id));
        return new ResponseEntity(phoneModel, HttpStatus.CREATED);

    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        phoneService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
