package com.test.spring.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Country {

    @Id
    @GeneratedValue
    private int id;
    private String country;

    @OneToOne(mappedBy = "country", cascade = {CascadeType.PERSIST,CascadeType.DETACH,
    CascadeType.MERGE,CascadeType.REFRESH})
    private Employee employee;

    public Country(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "\nCountry{" +
                "id=" + id +
                ", country='" + country + '\'' +
                '}';
    }
}
