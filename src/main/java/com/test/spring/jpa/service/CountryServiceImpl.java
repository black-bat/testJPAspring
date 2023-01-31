package com.test.spring.jpa.service;

import com.test.spring.jpa.entity.Country;
import com.test.spring.jpa.entity.Employee;
import com.test.spring.jpa.repository.CountryRepository;
import com.test.spring.jpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository countryRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Country> readAll() {
        return new ArrayList<>(countryRepository.findAll());
    }

    @Override
    public List<Country> readByCountry(String country) {
        return new ArrayList<>(countryRepository.findByCountry(country));
    }

    @Override
    public Country create(Country country, int employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        country.setEmployee(employee);
        return countryRepository.save(country);
    }

    @Override
    public Country updateCountryById(Country country, int id) {
        if (countryRepository.existsById(id)) {
            Country country1 = countryRepository.findById(id).get();
            country1.setId(country.getId());
            country1.setCountry(country.getCountry());
            return countryRepository.save(country1);
        }
        return null;
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
