package com.example.demo.Controllers;

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



    public Iterable<Truck> getAllTrucks()  {
         return truckService.getAllTrucks();
    }
}
