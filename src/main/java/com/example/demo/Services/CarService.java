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
    private TruckRepository truckRepo;

    @Autowired
    public void setTruckRepo(TruckRepository truckRepo) {
        this.truckRepo = truckRepo;
    }
    @Autowired
    public void setCarRepo(CarRepository carRepo) {
        this.carRepo = carRepo;
    }
    public Iterable<Car> getAllCars() {
        return carRepo.findAll();
    }



    public Car getCarById(Long id) {
        return carRepo.getCarById(id);
    }

    public Iterable<Car> getCarByMake(Manufacturer make) {
       return carRepo.getCarByCarManufacturer(make);
    }

    public Vehicle getCheapestVehicle() {
        Car cheapestCar = getCheapestCar();
        Truck cheapestTruck = getCheapestTruck();
        return cheapestCar.getPrice() < cheapestTruck.getPrice() ? cheapestCar:cheapestTruck;

        //condition ? A:B   if condition is true, return A.  if false, return B

//        if (cheapestCar.getPrice() < cheapestTruck.getPrice()) {
//            return cheapestCar;
//        }else return cheapestTruck;

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
        List<Truck> trucks = (List<Truck>) truckRepo.findAll();
        Truck cheapestTruck = null;
        double cheapestPricedTruck = 1000000.0;
        for (Truck t : trucks) {
            if (t.getPrice() < cheapestPricedTruck) {
                cheapestPricedTruck = t.getPrice();
                cheapestTruck = t;
            }
        }
        return cheapestTruck;
    }
}
