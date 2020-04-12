package com.example.demo.repository;

import com.example.demo.entity.Apartment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRepository extends CrudRepository<Apartment, Long> {

    Apartment findByName(String name);
}
