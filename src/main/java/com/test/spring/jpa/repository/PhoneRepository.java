package com.test.spring.jpa.repository;

//import com.test.spring.jpa.entity.Country;
import com.test.spring.jpa.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone,Integer> {
}
