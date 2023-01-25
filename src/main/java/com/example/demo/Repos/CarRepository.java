package com.example.demo.Repos;

import com.example.demo.Model.Car;
import com.example.demo.Model.Manufacturer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository  extends CrudRepository<Car, Long> {

    public Car getCarById(Long id);

    public Iterable<Car> getCarByCarManufacturer(Manufacturer make);
}
