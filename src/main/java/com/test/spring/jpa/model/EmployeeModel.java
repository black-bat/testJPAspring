package com.test.spring.jpa.model;

import com.test.spring.jpa.entity.Employee;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeModel {
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private java.sql.Date dateBirth;
    private List<PetModel> petModels;

    private List<PhoneModel> phoneModels;
    private CountryModel countryModel;

    public EmployeeModel() {
    }

    public static List<EmployeeModel> readAllModel(List<Employee> employee) {
        List<EmployeeModel> employeeModels = new ArrayList<>();
        for (Employee employee1 : employee) {
            employeeModels.add(EmployeeModel.toModel(employee1));
        }
        return employeeModels;
    }

    public static EmployeeModel toModel(Employee employee) {
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setId(employee.getId());
        employeeModel.setFirstName(employee.getFirstName());
        employeeModel.setLastName(employee.getLastName());
        employeeModel.setGender(employee.getGender());
        employeeModel.setEmail(employee.getEmail());
        employeeModel.setDateBirth(employee.getDateBirth());
        employeeModel.setCountryModel(CountryModel.toModel(employee.getCountry()));
        employeeModel.setPhoneModels(employee.getPhones().stream().map(PhoneModel::toModel).collect(Collectors.toList()));
        employeeModel.setPetModels(employee.getPets().stream().map(PetModel::toModel).collect(Collectors.toList()));
        return employeeModel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public List<PetModel> getPetModels() {
        return petModels;
    }

    public void setPetModels(List<PetModel> petModels) {
        this.petModels = petModels;
    }

    public CountryModel getCountryModel() {
        return countryModel;
    }

    public void setCountryModel(CountryModel countryModel) {
        this.countryModel = countryModel;
    }

    public List<PhoneModel> getPhoneModels() {
        return phoneModels;
    }

    public void setPhoneModels(List<PhoneModel> phoneModels) {
        this.phoneModels = phoneModels;
    }
}
