package com.example.demo;

import com.example.demo.Model.Car;
import com.example.demo.Model.Manufacturer;
import com.example.demo.Model.Truck;
import com.example.demo.Repos.CarRepository;
import com.example.demo.Repos.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabasePopulator implements CommandLineRunner {

    CarRepository carRepo;
    TruckRepository truckRepo;

    @Override
    public void run(String... args) throws Exception {
        Car car1 = new Car(Manufacturer.TOYOTA, "Camry", 18000);
        carRepo.save(car1);
        Car car2 = new Car(Manufacturer.AUDI, "A1", 19000);
        carRepo.save(car2);
        Car car3 = new Car(Manufacturer.ROLLS_ROYCE, "Phantom", 360000);
        carRepo.save(car3);
        Car car4 = new Car(Manufacturer.AUDI, "Quatro", 20000);
        carRepo.save(car4);

        Truck truck1 = new Truck(Manufacturer.TOYOTA, "4Runner", 15000, 2.0);
        truckRepo.save(truck1);
        Truck truck2 = new Truck(Manufacturer.TOYOTA, "Hylex", 17000, 2.5);
        truckRepo.save(truck2);
        Truck truck3 = new Truck(Manufacturer.TOYOTA, "4Runner", 12000, 2.0);
        truckRepo.save(truck3);

    }

    @Autowired
    public void setCarRepo(CarRepository carRepo) {
        this.carRepo = carRepo;
    }

    @Autowired
    public void setTruckRepo(TruckRepository truckRepo) {
        this.truckRepo = truckRepo;
    }
}
