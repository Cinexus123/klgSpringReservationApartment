package com.example.demo.controller;

import com.example.demo.command.ReservationCommand;
import com.example.demo.entity.Reservation;
import com.example.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/apartmentReservation")
public class ReservationController {

    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("")
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationCommand reservationCommand) {
        return ResponseEntity.ok(reservationService.createReservation(reservationCommand));
    }

    @PutMapping("updateReservation/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody ReservationCommand reservationCommand) {
        return ResponseEntity.ok(reservationService.updateReservation(id, reservationCommand));
    }

    @GetMapping("/ownerName/{ownerName}")
    public ResponseEntity<List<Reservation>> getOwnerReservation(@PathVariable String ownerName) {
        List<Reservation> reservationList = reservationService.getOwnerReservation(ownerName);
        return (reservationList.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(reservationList));
    }

    @GetMapping("/findApartment/{apartmentName}")
    public ResponseEntity<List<Reservation>> getApartmentReservation(@PathVariable String apartmentName) {
        List<Reservation> reservationList = reservationService.getApartmentReservation(apartmentName);
        return (reservationList.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(reservationList));
    }

}
