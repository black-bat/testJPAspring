package com.test.spring.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Phone {

    @Id
    @GeneratedValue
    private int id;

    private String number;

    public Phone(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "\nPhone{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
