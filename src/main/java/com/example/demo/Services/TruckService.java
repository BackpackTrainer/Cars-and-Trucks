package com.example.demo.Services;

import com.example.demo.Model.Truck;
import com.example.demo.Repos.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TruckService {

    private TruckRepository truckRepo;
    public Iterable<Truck> getAllTrucks()  {
        return truckRepo.findAll();
    }
    @Autowired
    public void setTruckRepo(TruckRepository truckRepo) {
        this.truckRepo = truckRepo;
    }
}
