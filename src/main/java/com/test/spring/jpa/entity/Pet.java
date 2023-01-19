package com.test.spring.jpa.entity;

import jakarta.persistence.*;

@Entity
public class Pet {
    @Id
    @GeneratedValue
    private int id;
    private String view;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Pet() {
    }

    public Pet(String view) {
        this.view = view;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
