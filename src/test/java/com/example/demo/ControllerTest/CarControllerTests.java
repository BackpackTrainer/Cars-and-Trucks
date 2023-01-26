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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CarController.class)
@AutoConfigureMockMvc
public class CarControllerTests {

    @MockBean
    private CarService carService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetCarByIdStatusCodeOKWithValidId() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/cars/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    public void testGetCarByIdReturnsCar() throws Exception {
        long carId = 1;
        Car expectedCar = new Car(Manufacturer.TOYOTA, "Camry", 18000);
        when(carService.getCarById(carId)).thenReturn(expectedCar);

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/cars/{carId}", carId)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept("application/json"))
                    .andExpectAll(
                            status().isOk(),
                            content().contentType(MediaType.APPLICATION_JSON),
                            jsonPath("$.model").value("Camry"),
                            jsonPath("$.price").value(18000),
                            jsonPath("$.carManufacturer").value(Manufacturer.TOYOTA.toString())
        );
    }
}
