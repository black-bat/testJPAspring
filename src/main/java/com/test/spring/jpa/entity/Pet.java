package com.test.spring.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Pet {
    @Id
    @GeneratedValue
    private int id;
    private String view;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Pet(String view) {
        this.view = view;
    }

    @Override
    public String toString() {
        return "\nPet{" +
                "id=" + id +
                ", view='" + view + '\'' +
                ", employee=" + employee +
                '}';
    }
}
