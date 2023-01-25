package com.example.demo.ControllerTest;

import com.example.demo.Controllers.CarController;
import com.example.demo.Model.Car;
import com.example.demo.Model.Manufacturer;
import com.example.demo.Services.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.contains;
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

    @Autowired
    private CarController carController;

    @Test
    public void itStarts()  {
        assertThat(carController).isNotNull();
    }

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
                .get("http://localhost:8080/cars/"));

        verify(carService, times(1)).getAllCars();
    }
}
