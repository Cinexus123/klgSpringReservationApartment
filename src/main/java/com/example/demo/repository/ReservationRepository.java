package com.example.demo.repository;

import com.example.demo.entity.Reservation;
import com.example.demo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    List<Reservation> findAllByOwner(User owner);

    List<Reservation> findAllByApartmentName(String name);
}
