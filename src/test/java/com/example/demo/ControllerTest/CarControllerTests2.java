package com.example.demo.ControllerTest;

import com.example.demo.Controllers.CarController;
import com.example.demo.Model.Car;
import com.example.demo.Model.Manufacturer;
import com.example.demo.Services.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(CarController.class)
@AutoConfigureMockMvc
public class CarControllerTests2 {
    @MockBean
    private CarService carService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void addingFeaturesToTestGettingCarById() throws Exception {


        long carId = 1;
        Car expectedCar = new Car(Manufacturer.TOYOTA, "Camry", 18000);
        when(carService.getCarById(carId)).thenReturn(expectedCar);

        mockMvc.perform(MockMvcRequestBuilders
                .get("http://localhost:8080/cars/" + carId))
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$.model").value("Camry")
                     );
    }

    @Test
    public void testGettingCarById() throws Exception {

        long carId = 1;

        mockMvc.perform(MockMvcRequestBuilders
                        .get("http://localhost:8080/cars/" + carId));

        verify(carService, times(1)).getCarById(carId);
    }

    @Test
    public void testGettingAllCars() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .get("http://localhost:8080/cars"))
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON)
                );

        verify(carService, times(1)).getAllCars();
    }

    @Test
    public void testFindingCheapestCar() throws Exception {
        Car cheapestCar = new Car(Manufacturer.TOYOTA, "Camry", 18000);

        when(carService.getCheapestCar()).thenReturn(cheapestCar);

        mockMvc.perform(MockMvcRequestBuilders
                .get("http://localhost:8080/cheapestCar"))
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("price").value(18000)
                );

        verify(carService, times(1)).getCheapestCar();
    }
}
