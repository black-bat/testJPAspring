package com.test.spring.jpa.controller;

import com.test.spring.jpa.entity.Country;
import com.test.spring.jpa.entity.Pet;
import com.test.spring.jpa.model.CountryModel;
import com.test.spring.jpa.model.PetModel;
import com.test.spring.jpa.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping(value = "/countries")
    public ResponseEntity<List<CountryModel>> readAll() {
        final List<Country> countries = countryService.readAll();
        return countries != null && !countries.isEmpty()
                ? new ResponseEntity<>(CountryModel.readAllModel(countries), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/countries/name/{country}")
    public ResponseEntity<List<CountryModel>> readByCountry(@PathVariable(name = "country") String str) {
        final List<Country> countries = countryService.readByCountry(str);
        return countries != null && !countries.isEmpty()
                ? new ResponseEntity<>(CountryModel.readAllModel(countries), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/counties/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = countryService.deleteById(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
