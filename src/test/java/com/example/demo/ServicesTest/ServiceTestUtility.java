package com.example.demo.ServicesTest;

import com.example.demo.Model.Car;
import com.example.demo.Model.Manufacturer;
import com.example.demo.Model.Truck;

import java.util.List;

public class ServiceTestUtility {

    public static List<Truck> getListOfTrucks()  {
        Truck truck1 = new Truck(Manufacturer.TOYOTA, "4Runner", 15000, 2.0);
        Truck truck2 = new Truck(Manufacturer.TOYOTA, "Hylex", 17000, 2.5);
        Truck cheapestTruck = new Truck(Manufacturer.TOYOTA, "4Runner", 12000, 2.0);
        List<Truck> trucks = List.of(truck1, truck2, cheapestTruck);

        return trucks;
    }

    public static List<Car> getListOfCars()  {
        Car cheapestCar = new Car(Manufacturer.TOYOTA, "Camry", 18000);
        Car car2 = new Car(Manufacturer.AUDI, "A1", 19000);
        Car car3 = new Car(Manufacturer.ROLLS_ROYCE, "Phantom", 360000);
        Car car4 = new Car(Manufacturer.AUDI, "Quatro", 20000);
        List<Car> cars = List.of(cheapestCar, car2, car3, car4);

        return cars;
    }
}
