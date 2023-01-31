package com.test.spring.jpa.controller;

import com.test.spring.jpa.entity.Country;
import com.test.spring.jpa.entity.Pet;
import com.test.spring.jpa.exception.ResourceNotFoundException;
import com.test.spring.jpa.model.CountryModel;
import com.test.spring.jpa.model.PetModel;
import com.test.spring.jpa.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping(value = "/countries")
    public ResponseEntity<List<CountryModel>> readAll() {
        List<Country> countries = countryService.readAll();
        return countries != null && !countries.isEmpty()
                ? new ResponseEntity<>(CountryModel.readAllModel(countries), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/countries/name/{country}")
    public ResponseEntity<List<CountryModel>> readByCountry(@PathVariable(name = "country") String str) {
        List<Country> countries = countryService.readByCountry(str);
        try {
            return countries != null && !countries.isEmpty() ?
                    new ResponseEntity<>(CountryModel.readAllModel(countries), HttpStatus.OK) :
                    new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch ( ResourceNotFoundException e ) {
            throw new ResourceNotFoundException("Not found Country = " + str);
        }
    }

    @PostMapping(value = "/countries")
    public ResponseEntity<CountryModel> createCountry(@RequestBody Country country,
                                                      @RequestParam int id) {
        CountryModel countryModel = CountryModel.toModel(countryService.create(country, id));
        return new ResponseEntity(countryModel, HttpStatus.CREATED);
    }

    @PutMapping(value = "/countries")
    public ResponseEntity<CountryModel> completePet(@RequestBody Country country,
                                                    @RequestParam int id) {
        try {
            return new ResponseEntity<>(CountryModel.toModel(countryService.updateCountryById(country, id)), HttpStatus.OK);
        } catch ( Exception e ) {
            throw new ResourceNotFoundException("Not found Country with id = " + id);
        }
    }

    @DeleteMapping(value = "/counties/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(name = "id") int id) {
        countryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
