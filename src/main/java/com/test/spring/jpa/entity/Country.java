package com.test.spring.jpa.entity;

import jakarta.persistence.*;

@Entity
public class Country {

    @Id
    @GeneratedValue
    private int id;
    private String country;

    @OneToOne(mappedBy = "country", cascade = {CascadeType.PERSIST,CascadeType.DETACH,
    CascadeType.MERGE,CascadeType.REFRESH})
    private Employee employee;

    public Country() {
    }

    public Country(String country) {
        this.country = country;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "\nCountry{" +
                "id=" + id +
                ", country='" + country + '\'' +
                '}';
    }
}
