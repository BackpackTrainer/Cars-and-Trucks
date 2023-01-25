package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Truck extends Vehicle{
    @Id
    @GeneratedValue
    Long id;

    Manufacturer make;
    String model;
    double price;
    double capacity;

    public Truck()  {}

    public Truck(Manufacturer make, String model, double price, double capacity) {
        this.make = make;
        this.model = model;
        this.price = price;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public Manufacturer getMake() {
        return make;
    }

    public void setMake(Manufacturer make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }
}
