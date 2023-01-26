package com.example.demo.ControllerTest;

import com.example.demo.Controllers.CarController;
import com.example.demo.Model.Car;
import com.example.demo.Model.Manufacturer;
import com.example.demo.Model.Truck;
import com.example.demo.Services.CarService;
import com.example.demo.Services.TruckService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@WebMvcTest(CarController.class)
@AutoConfigureMockMvc
public class ControllerTests3 {

    @MockBean
    private CarService carService;

    @MockBean
    private TruckService truckService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetCarsById() throws Exception {
        long carId = 1;
        Car expectedCar = new Car(Manufacturer.TOYOTA, "Camry", 18000);
        when(carService.getCarById(carId)).thenReturn(expectedCar);

        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost8080/cars/" + carId))
                        .andExpectAll(
                                status().isOk(),
                                content().contentType(MediaType.APPLICATION_JSON),
                                jsonPath("$.model").value("Camry"),
                                jsonPath("$.price").value(18000),
                                jsonPath("$.carManufacturer").value((Manufacturer.TOYOTA).toString())
                        );

        verify(carService, times(1)).getCarById(carId);
    }

    @Test
    public void testWithUnusedId() throws Exception {

        long carId = 14;
        Car expectedCar = new Car(Manufacturer.TOYOTA, "Camry", 18000);
        when(carService.getCarById(carId)).thenReturn(expectedCar);

        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost8080/cars/" + carId))
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON)
                );
        verify(carService, times(1)).getCarById(carId);
    }

    @Test
    public void testGettingCheapestVehicleMakesProperCall() throws Exception {
        Car cheapestCar = new Car(Manufacturer.TOYOTA, "Camry", 18000);
        when(carService.getCheapestVehicle()).thenReturn(cheapestCar);

        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost8080/cheapestVehicle"))
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON)
                );
        verify(carService, times(1)).getCheapestVehicle();

    }
}
