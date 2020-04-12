package com.example.demo.service.impl;

import com.example.demo.command.ReservationCommand;
import com.example.demo.entity.Apartment;
import com.example.demo.entity.Reservation;
import com.example.demo.entity.User;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.ApartmentRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private ReservationRepository reservationRepository;
    private PersonRepository personRepository;
    private ApartmentRepository apartmentRepository;

    @Override
    public Reservation createReservation(ReservationCommand reservationCommand) {
        Reservation reservation = new Reservation(
                reservationCommand.getStartReservation(),
                reservationCommand.getFinishReservation(),
                reservationCommand.getApartment(),
                reservationCommand.getOwner(),
                reservationCommand.getBorrower(),
                reservationCommand.getPrice());

        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Long id, ReservationCommand reservationCommand) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);

        if (!optionalReservation.isPresent()) {
            throw new NotFoundException();
        }

        Reservation reservation = optionalReservation.get();
        reservation.setApartment(reservationCommand.getApartment());
        reservation.setOwner(reservationCommand.getOwner());
        reservation.setBorrower(reservationCommand.getBorrower());
        reservation.setPrice(reservationCommand.getPrice());
        reservation.setStartReservation(reservationCommand.getStartReservation());
        reservation.setFinishReservation(reservationCommand.getFinishReservation());

        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getOwnerReservation(String name) {
        User owner = personRepository.findByName(name);
        return reservationRepository.findAllByOwner(owner);
    }

    @Override
    public List<Reservation> getApartmentReservation(String name) {
        Apartment apartmentName = apartmentRepository.findByName(name);
        return reservationRepository.findAllByApartmentName(apartmentName.getName());
    }

}
