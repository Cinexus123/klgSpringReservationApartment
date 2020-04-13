package com.example.demo.command;

import com.example.demo.entity.Apartment;
import com.example.demo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReservationCommand {

    private LocalDateTime startReservation;
    private LocalDateTime finishReservation;
    private Apartment apartment;
    private User owner;
    private User borrower;
    private Double price;


    public ReservationCommand() {
    }

    public ReservationCommand(LocalDateTime startReservation, LocalDateTime finishReservation, Apartment apartment, User owner, User borrower, Double price) {
        this.startReservation = startReservation;
        this.finishReservation = finishReservation;
        this.apartment = apartment;
        this.owner = owner;
        this.borrower = borrower;
        this.price = price;
    }

    public LocalDateTime getStartReservation() {
        return startReservation;
    }

    public void setStartReservation(LocalDateTime startReservation) {
        this.startReservation = startReservation;
    }

    public LocalDateTime getFinishReservation() {
        return finishReservation;
    }

    public void setFinishReservation(LocalDateTime finishReservation) {
        this.finishReservation = finishReservation;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getBorrower() {
        return borrower;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}