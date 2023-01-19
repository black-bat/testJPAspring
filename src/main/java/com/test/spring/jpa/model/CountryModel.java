package com.test.spring.jpa.model;

import com.test.spring.jpa.entity.Country;
import com.test.spring.jpa.entity.Pet;

import java.util.ArrayList;
import java.util.List;

public class CountryModel {

    private int id;
    private String country;

    public CountryModel() {
    }

    public static CountryModel toModel(Country country) {
        CountryModel countryModel = new CountryModel();
        countryModel.setId(country.getId());
        countryModel.setCountry(country.getCountry());
        return countryModel;
    }

    public static List<CountryModel> readAllModel(List<Country> countries) {
        List<CountryModel> countryModels = new ArrayList<>();
        for (Country country1 : countries) {
            countryModels.add(CountryModel.toModel(country1));
        }
        return countryModels;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
