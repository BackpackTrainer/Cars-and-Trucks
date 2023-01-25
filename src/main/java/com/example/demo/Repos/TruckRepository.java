package com.example.demo.Repos;


import com.example.demo.Model.Truck;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckRepository extends CrudRepository<Truck, Long> {


}
