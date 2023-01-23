package com.test.spring.jpa.model;

import com.test.spring.jpa.entity.Country;
import com.test.spring.jpa.entity.Pet;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
public class CountryModel {

    private int id;
    private String country;

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
}
