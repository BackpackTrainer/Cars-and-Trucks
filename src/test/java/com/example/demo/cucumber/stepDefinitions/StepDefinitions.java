package com.example.demo.cucumber.stepDefinitions;

import com.example.demo.DemoApplication;
import com.example.demo.Model.Car;
import com.example.demo.Model.Manufacturer;
import com.example.demo.Services.CarService;
import com.example.demo.Services.TruckService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@CucumberContextConfiguration
//@WebMvcTest
@SpringBootTest  //new
@AutoConfigureMockMvc  //new
@RunWith(SpringRunner.class)
public class StepDefinitions {

    //@Autowired
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    //@MockBean
    private CarService carService;

    @Autowired
    //@MockBean
    private TruckService truckService;

    private ResultActions action;

    @Given("I send a get request to cars")
    public void i_send_a_get_reequest_to_cars() {
        assertNotNull(mockMvc);
    }
    @When("I parse the response")
    public void i_parse_the_response() throws Exception {
        long carId = 1;
        Car expectedCar = new Car(Manufacturer.TOYOTA, "Camry", 18000);
        //when(carService.getCarById(carId)).thenReturn(expectedCar);

        action = mockMvc.perform(
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

    @Then("I get a list of cars")
    public void i_get_a_list_of_cars() throws Exception {
        action.andExpectAll(
                status().isOk(),
                content().contentType(MediaType.APPLICATION_JSON),
                jsonPath("$.model").value("Camry"),
                jsonPath("$.price").value(18000),
                jsonPath("$.carManufacturer").value(Manufacturer.TOYOTA.toString())
        );

    }
}
