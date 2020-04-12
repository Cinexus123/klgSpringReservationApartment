package com.example.demo.service;

import com.example.demo.command.ReservationCommand;
import com.example.demo.entity.Reservation;

import java.util.List;

public interface ReservationService {

    Reservation createReservation(ReservationCommand reservationCommand);

    Reservation updateReservation(Long id, ReservationCommand reservationCommand);

    List<Reservation> getOwnerReservation(String ownerName);

    List<Reservation> getApartmentReservation(String name);
}
