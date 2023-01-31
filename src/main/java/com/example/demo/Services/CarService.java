package com.example.demo.Services;

import com.example.demo.Model.Car;
import com.example.demo.Model.Manufacturer;
import com.example.demo.Model.Truck;
import com.example.demo.Model.Vehicle;
import com.example.demo.Repos.CarRepository;
import com.example.demo.Repos.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarService {

    private CarRepository carRepo;
    //private TruckRepository truckRepo;

    private TruckService truckService;

    @Autowired
    public void setTruckService(TruckService truckService) {
        this.truckService = truckService;
    }
    @Autowired
    public void setCarRepo(CarRepository carRepo) {
        this.carRepo = carRepo;
    }
    public Iterable<Car> getAllCars() {
        return carRepo.findAll();
    }



    public Car getCarById(Long id) {
        System.out.println("Car service getCarById method called with parameter of " + id);
        return carRepo.getCarById(id);
    }

    public Iterable<Car> getCarByMake(Manufacturer make) {
       return carRepo.getCarByCarManufacturer(make);
    }

    public Vehicle getCheapestVehicle() {
        Car cheapestCar = getCheapestCar();
        Truck cheapestTruck = getCheapestTruck();
        return cheapestCar.getPrice() < cheapestTruck.getPrice() ? cheapestCar:cheapestTruck;
    }

    public Car getCheapestCar() {
        List<Car> cars = (List<Car>) carRepo.findAll();
        Car cheapestCar = null;
        double cheapestPrice = 1000000.0;
        for (Car c : cars) {
            if (c.getPrice() < cheapestPrice) {
                cheapestPrice = c.getPrice();
                cheapestCar = c;
            }
        }
        return cheapestCar;
    }

    public Truck getCheapestTruck() {
       return truckService.getCheapestTruck();
        }
}
