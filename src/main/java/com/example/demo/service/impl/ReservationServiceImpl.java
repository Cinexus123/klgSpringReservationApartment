package com.example.demo.service.impl;

import com.example.demo.command.ReservationCommand;
import com.example.demo.entity.Apartment;
import com.example.demo.entity.Reservation;
import com.example.demo.entity.User;
import com.example.demo.exception.NotFoundException;
import com.example.demo.exception.ReservationNotAvailableException;
import com.example.demo.repository.ApartmentRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.ZoneOffset;
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

        return getReservation(reservationCommand, reservation);
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

        return getReservation(reservationCommand, reservation);
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

    private Reservation getReservation(ReservationCommand reservationCommand, Reservation reservation) {
        long startReservationElement = 0;
        long finishReservationElement = 0;
        long startReservationInSeconds = reservationCommand.getStartReservation().toEpochSecond(ZoneOffset.UTC);
        long finishReservationInSeconds = reservationCommand.getFinishReservation().toEpochSecond(ZoneOffset.UTC);

        List<Reservation> reservationList = reservationRepository.findAllByApartmentName(reservationCommand.getApartment().getName());

        if(reservationList == null)
        {
            return reservationRepository.save(reservation);
        }

        for(Reservation element : reservationList) {
            startReservationElement = element.getStartReservation().toEpochSecond(ZoneOffset.UTC);
            finishReservationElement = element.getFinishReservation().toEpochSecond(ZoneOffset.UTC);
            if (((startReservationElement > startReservationInSeconds) && (startReservationElement < finishReservationInSeconds)) ||
                    (finishReservationElement > startReservationInSeconds) && (finishReservationElement < finishReservationInSeconds) ||
                    (startReservationElement <= startReservationInSeconds) && (finishReservationElement > finishReservationInSeconds))

            {
                throw new ReservationNotAvailableException();
            }
        }

        return reservationRepository.save(reservation);
    }

}
