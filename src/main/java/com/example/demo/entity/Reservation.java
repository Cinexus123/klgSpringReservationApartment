package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startReservation;
    private LocalDate finishReservation;

    @ManyToOne
    private Apartment apartment;

    @ManyToOne
    private User owner;

    @ManyToOne
    private User borrower;

    private Double price;

    public Reservation(LocalDate startReservation, LocalDate finishReservation, Apartment apartment, User owner, User borrower, Double price) {
        this.startReservation = startReservation;
        this.finishReservation = finishReservation;
        this.apartment = apartment;
        this.owner = owner;
        this.borrower = borrower;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartReservation() {
        return startReservation;
    }

    public void setStartReservation(LocalDate startReservation) {
        this.startReservation = startReservation;
    }

    public LocalDate getFinishReservation() {
        return finishReservation;
    }

    public void setFinishReservation(LocalDate finishReservation) {
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