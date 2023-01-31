package com.example.demo.Controllers;

import com.example.demo.Model.Car;
import com.example.demo.Model.Manufacturer;
import com.example.demo.Model.Truck;
import com.example.demo.Model.Vehicle;
import com.example.demo.Services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("cars")
    public Iterable<Car> getAllCars()  {
        return carService.getAllCars();
    }

    @GetMapping("cars/{id}")
    public Car getCarById(@PathVariable Long id)  {
        System.out.println("Request received with a parameter of " + id);
        return carService.getCarById(id);
    }

    @GetMapping("carsByMake/{make}")
    public Iterable<Car> getCarByMake(@PathVariable Manufacturer make)  {
        return carService.getCarByMake(make);
    }

    @GetMapping("cheapestVehicle")
    public Vehicle getCheapestVehicle()  {

        return carService.getCheapestVehicle();
    }

    @GetMapping("cheapestCar")
    public Car getCheapestCar() {
        return carService.getCheapestCar();
    }
}
