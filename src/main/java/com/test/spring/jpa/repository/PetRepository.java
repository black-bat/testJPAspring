package com.test.spring.jpa.repository;

import com.test.spring.jpa.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PetRepository extends JpaRepository<Pet,Integer> {

}
