package com.example.demo.Services;

import com.example.demo.Model.Truck;
import com.example.demo.Repos.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TruckService {

    private TruckRepository truckRepo;
    public Iterable<Truck> getAllTrucks()  {
        return truckRepo.findAll();
    }

    public Truck getTruckById(Long id)  {
        return truckRepo.getTruckById(id);
    }

    @Autowired
    public void setTruckRepo(TruckRepository truckRepo) {
        this.truckRepo = truckRepo;
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
