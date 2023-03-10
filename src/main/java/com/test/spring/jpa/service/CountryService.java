package com.test.spring.jpa.service;

import com.test.spring.jpa.entity.Country;
import com.test.spring.jpa.entity.Pet;

import java.util.List;

public interface CountryService {
    List<Country> readAll();

    List<Country> readByCountry(String country);

    Country create(Country country, int employeeId);

    Country updateCountryById(Country country, int id);

    boolean deleteById(int id);
}
