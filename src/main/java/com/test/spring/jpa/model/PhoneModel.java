package com.test.spring.jpa.model;

import com.test.spring.jpa.entity.Pet;
import com.test.spring.jpa.entity.Phone;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
public class PhoneModel {
    private int id;
    private String number;

    public static PhoneModel toModel(Phone phone) {
        PhoneModel phoneModel = new PhoneModel();
        phoneModel.setId(phone.getId());
        phoneModel.setNumber(phone.getNumber());
        return phoneModel;
    }

    public static List<PhoneModel> readAllModel(List<Phone> phones) {
        List<PhoneModel> phoneModels = new ArrayList<>();
        for (Phone phone : phones) {
            phoneModels.add(PhoneModel.toModel(phone));
        }
        return phoneModels;
    }
}
