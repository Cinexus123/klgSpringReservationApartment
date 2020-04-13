package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Apartment {

    @Id
    private String name;
    private String description;
    private Double price;
    private Double surface;

    public Apartment() {
    }

    public Apartment(String name, String description, Double price, Double surface) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.surface = surface;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSurface() {
        return surface;
    }

    public void setSurface(Double surface) {
        this.surface = surface;
    }
}