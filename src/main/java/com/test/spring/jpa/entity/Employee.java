package com.test.spring.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private java.sql.Date dateBirth;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private Country country;

    //  uni-directional
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private List<Phone> phones;

    //bi-directional
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "employee",
            cascade = CascadeType.ALL)
    private List<Pet> pets;

    public Employee(String firstName, String lastName, String gender, String email, Date dateBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.dateBirth = dateBirth;
    }

    public Employee(int id, String firstName, String lastName, String gender, String email, Date dateBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.dateBirth = dateBirth;
    }

    public void setPets(List<Pet> pets) {
        if (pets != null) {
            pets.forEach(a -> {
                a.setEmployee(this);
            });
        }
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", dateBirth=" + dateBirth +
                '}';
    }
}
