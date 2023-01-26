package com.example.demo.Controllers;

import com.example.demo.Model.Car;
import com.example.demo.Model.Truck;
import com.example.demo.Services.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TruckController {
     private TruckService truckService;

     @Autowired
    public void setTruckService(TruckService truckService) {
        this.truckService = truckService;
    }


    @GetMapping("trucks")
    public Iterable<Truck> getAllTrucks()  {
         return truckService.getAllTrucks();
    }

    @GetMapping("trucks/{id}")
    public Truck getTruckById(@PathVariable Long id)  {
        System.out.println("Request received with a parameter of " + id);
        return truckService.getTruckById(id);
    }

    @GetMapping("/trucks/cheapestTruck")
    public Truck getCheapestTruck()  {
         return truckService.getCheapestTruck();
    }
}
