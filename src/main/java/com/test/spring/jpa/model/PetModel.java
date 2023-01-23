package com.test.spring.jpa.model;

import com.test.spring.jpa.entity.Employee;
import com.test.spring.jpa.entity.Pet;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
public class PetModel {

    private int id;
    private String view;

    public static PetModel toModel(Pet pet) {
        PetModel petModel = new PetModel();
        petModel.setId(pet.getId());
        petModel.setView(pet.getView());
        return petModel;
    }

    public static List<PetModel> readAllModel(List<Pet> pets) {
        List<PetModel> petModels = new ArrayList<>();
        for (Pet pet : pets) {
            petModels.add(PetModel.toModel(pet));
        }
        return petModels;
    }
}
