package com.example.demo.ServicesTest;

import com.example.demo.Model.Car;
import com.example.demo.Model.Manufacturer;
import com.example.demo.Model.Truck;
import com.example.demo.Model.Vehicle;
import com.example.demo.Repos.CarRepository;
import com.example.demo.Repos.TruckRepository;
import com.example.demo.Services.CarService;
import com.example.demo.Services.TruckService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.example.demo.ServicesTest.ServiceTestUtility.getListOfCars;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CarServiceTest {

    CarService uut;
    CarRepository repository;
    Car car;
    long carId;
    Car actualCar;

    @BeforeEach
    public void setUp()  {
        repository = mock(CarRepository.class);
        car = mock(Car.class);
        uut = new CarService();
        uut.setCarRepo(repository);
    }

    @Test
    public void testGetCarById()  {
        carId = 1;
        when(repository.getCarById(carId)).thenReturn(car);
        when(car.getId()).thenReturn(carId);

      actualCar = uut.getCarById(carId);

      assertEquals(carId, actualCar.getId());
    }

    @Test
    public void testGetCarById2()  {
        carId = 1;
       // when(repository.getCarById(carId)).thenReturn(car);
        uut.getCarById(carId);

        verify(repository, times(1)).getCarById(carId);
    }

    @Test
    public void testGettingCheapestCar()  {
        Car actualResult;
        Car cheapestCar = new Car(Manufacturer.TOYOTA, "Camry", 18000);
        Car car2 = new Car(Manufacturer.AUDI, "A1", 19000);
        Car car3 = new Car(Manufacturer.ROLLS_ROYCE, "Phantom", 360000);
        Car car4 = new Car(Manufacturer.AUDI, "Quatro", 20000);
        List<Car> cars = List.of(cheapestCar, car2, car3, car4);

        when(repository.findAll()).thenReturn(cars);

        actualResult = uut.getCheapestCar();

        assertEquals(cheapestCar, actualResult);

    }

    @Test
    public void testGettingCheapestVehicle()  {
        Vehicle actualResult;

        TruckService truckService;


        actualResult = uut.getCheapestVehicle();

        Truck cheapestTruck = ServiceTestUtility.getListOfTrucks().get(2);

       assertEquals(cheapestTruck.getPrice(), actualResult.getPrice());
    }

}
