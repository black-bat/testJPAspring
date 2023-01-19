package com.test.spring.jpa.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.spring.jpa.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class EmployeeRepositoryTest {
//    @Autowired
//    EmployeeRepository repository;
//
//    @Autowired
//    CountryRepository countryRepository;
//
//    @Test
//    public void findByFirstName() throws Exception {
//        List<Employee> emplo = repository.findByFirstName("Abu");
//        assertThat(emplo).hasSize(1);
//        assertThat(emplo.get(0).getLastName()).isEqualTo("ABA");
//    }
//
//    @Test
//    public void findAllEmployeeByFirstName() throws Exception {
//        List<Employee> employ = repository.findAllEmployeeByFirstName();
//        assertThat(employ).hasSize(3);
//        assertThat(employ.get(1).getFirstName()).isEqualTo("Coin");
//        assertThat(employ.get(2).getFirstName()).isEqualTo("Sandy");
//    }
//
//    @Test
//    public void ownerTest() throws Exception {
//
//        Employee emp = repository.findById(1).get();
//        System.out.println("888888888888888");
//        System.out.println(emp);
//        ObjectMapper objectMapper=new ObjectMapper();
//        String s = objectMapper.writeValueAsString(emp);
//        System.out.println(s);
//    }

//    @Test
//    public void deleteCountry() throws Exception {
//        Country country = countryRepository.findByCountry("Turkey");
//        country.getEmployee().setCountry(null);
//        countryRepository.delete(country);

//        List<Employee> employees = repository.findAll();
//        assertThat(employees).hasSize(3);

//        List<Country> countres = countryRepository.findAll();
//        assertThat(countres).hasSize(2);


//}