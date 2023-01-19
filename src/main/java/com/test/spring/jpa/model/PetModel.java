package com.test.spring.jpa.model;

import com.test.spring.jpa.entity.Employee;
import com.test.spring.jpa.entity.Pet;

import java.util.ArrayList;
import java.util.List;

public class PetModel {

    private int id;
    private String view;

    public PetModel() {
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }
}
