package com.test.spring.jpa.model;

import com.test.spring.jpa.entity.Employee;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Data
@NoArgsConstructor
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
}
