package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Car extends Vehicle {
    @Id
    @GeneratedValue
    Long id;

    private Manufacturer carManufacturer;
    private String model;
    private double price;

    public Car()  {}

    public Car(Manufacturer make, String model, double price)  {
        carManufacturer = make;
        this.model = model;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public Manufacturer getCarManufacturer() {
        return carManufacturer;
    }

    public void setCarManufacturer(Manufacturer carManufacturer) {
        this.carManufacturer = carManufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(double listPrice) {
        this.price = listPrice;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
