package com.test.spring.jpa.repository;

import com.test.spring.jpa.entity.Employee;
import jakarta.transaction.Transactional;
import org.hibernate.LazyInitializationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class RelationTest {
//
//    @Autowired
//    EmployeeRepository repository;
//
////    @Test(expected = LazyInitializationException.class)
////    public void lazyLoading() throws Exception {
////
////        List<Employee> abu = repository.findByFirstName("Abu");
////        //session closed
////        System.out.println(abu.get(0).getPhones());
////    }
//
//    @Test
//    @Transactional
//    public void lazyLoadingTransactional() throws Exception {
//
//        List<Employee> abu = repository.findByFirstName("Abu");
//        System.out.println(abu.get(0).getPhones());
//        assertThat(abu.get(0).getPhones()).hasSize(2);
//    }
//}
