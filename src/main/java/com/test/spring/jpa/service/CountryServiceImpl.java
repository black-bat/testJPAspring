package com.test.spring.jpa.service;

import com.test.spring.jpa.entity.Country;
import com.test.spring.jpa.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository countryRepository;

    @Override
    public List<Country> readAll() {
        return new ArrayList<>(countryRepository.findAll());
    }

    @Override
    public List<Country> readByCountry(String country) {
        return new ArrayList<>(countryRepository.findByCountry(country));
    }

    @Override
    public boolean deleteById(int id) {
        if (countryRepository.existsById(id)) {
            countryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
