package com.test.spring.jpa;

//import com.test.spring.jpa.entity.Country;
// import com.test.spring.jpa.entity.Country;
import com.test.spring.jpa.entity.Country;
import com.test.spring.jpa.entity.Employee;
//import com.test.spring.jpa.entity.Pet;
//import com.test.spring.jpa.entity.Phone;
//import com.test.spring.jpa.repository.CountryRepository;
import com.test.spring.jpa.entity.Pet;
import com.test.spring.jpa.entity.Phone;
import com.test.spring.jpa.repository.CountryRepository;
import com.test.spring.jpa.repository.EmployeeRepository;
//import com.test.spring.jpa.repository.PetRepository;
//import com.test.spring.jpa.repository.PhoneRepository;
import com.test.spring.jpa.repository.PetRepository;
import com.test.spring.jpa.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = "com.test.spring.jpa.*")
@EntityScan("com.test.spring.jpa.*")

public class SpringJpaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaApplication.class, args);
    }

    @Autowired
    EmployeeRepository repository;

    @Autowired
    CountryRepository repositoryCountry;
    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private PetRepository petRepository;


    @Override
    public void run(String... args) throws Exception {

//        Employee employee1 = new Employee("Abu", "ABA", "Male", "adu@.com", Date.valueOf("1975-03-03"));
//        Employee employee2 = new Employee("Coin", "Coin", "Male", "coin@.com", Date.valueOf("1980-02-14"));
//        Employee employee3 = new Employee("Sandy", "Sun", "Female", "sandy@.com", Date.valueOf("1984-07-13"));
//
//        Country country1 = new Country("Australia");
//        Country country2 = new Country("China");
//        Country country3 = new Country("Turkey");
//        employee1.setCountry(country1);
//        employee2.setCountry(country2);
//        employee3.setCountry(country3);
//
//        Phone phone1 = new Phone("8-920-940-67-58");
//        Phone phone2 = new Phone("8-921-952-22-44");
//        Phone phone3 = new Phone("8-922-955-11-21");
//        Phone phone4 = new Phone("8-923-914-99-22");
//
//        Pet pet1=new Pet("dog");
//        Pet pet2=new Pet("cat");
//        Pet pet3=new Pet("duck");
//        Pet pet4=new Pet("hamster");
//
//        employee1.setPhones(Arrays.asList(phone1, phone2));
//        employee2.setPhones(Arrays.asList(phone3));
//        employee3.setPhones(Arrays.asList(phone4));
//
//        employee1.setPets(Arrays.asList(pet1));
//        employee2.setPets(Arrays.asList(pet2,pet4));
//        employee3.setPets(Arrays.asList(pet3));
//
//        List<Employee> employees = Arrays.asList(employee1, employee2, employee3);
//        repository.saveAll(employees);


        System.out.println("<<<<<<<<<<<< " + repository.findAll());
    //    System.out.println("<<<<<<<<<<<< " + repositoryCountry.findAll());
    //    System.out.println("<<<<<<<<<<<< " + phoneRepository.findAll());
    //    System.out.println("<<<<<<<<<<<< " + petRepository.findAll());
    }
}
