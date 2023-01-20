package com.test.spring.jpa.controller;

import com.test.spring.jpa.entity.Phone;
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
        final List<Phone> phones = phoneService.readAll();
        return phones != null && !phones.isEmpty()
                ? new ResponseEntity<>(PhoneModel.readAllModel(phones), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity createPhone(@RequestBody Phone phone,
                                      @RequestParam int id) {
        try {
            return ResponseEntity.ok(phoneService.create(phone, id));
        } catch ( Exception e ) {

            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping
    public ResponseEntity completePet(@RequestBody Phone phone,
                                      @RequestParam int id) {
        try {
            return ResponseEntity.ok(phoneService.updatePhoneById(phone, id));
        } catch ( Exception e ) {

            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = phoneService.deleteById(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
