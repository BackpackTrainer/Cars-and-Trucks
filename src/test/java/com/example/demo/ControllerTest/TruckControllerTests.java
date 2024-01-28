package com.example.demo.ControllerTest;


import com.example.demo.Controllers.TruckController;
import com.example.demo.Model.Car;
import com.example.demo.Model.Manufacturer;
import com.example.demo.Model.Truck;
import com.example.demo.Services.TruckService;
import com.example.demo.ServicesTest.ServiceTestUtility;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TruckController.class)
@AutoConfigureMockMvc
public class TruckControllerTests {

    @MockBean
    private TruckService truckService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testGettingAllTrucksMakesTheProperCall() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .get("http://localhost:8080/trucks"));

        verify(truckService, times(1)).getAllTrucks();
    }

    @Test public void testGettingAllTrucks()  throws Exception  {

        ObjectMapper mapper = new ObjectMapper();

        List<Truck> trucks = ServiceTestUtility.getListOfTrucks();
        when(truckService.getAllTrucks()).thenReturn(trucks);

        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders
                        .get("http://localhost:8080/trucks"))
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON)
                );

        MvcResult result = actions.andReturn();
        String contents = result.getResponse().getContentAsString();
        Truck[] returnedTrucks = mapper.readValue(contents, Truck[].class);
        assertTrue(returnedTrucks.length == 3);

        for(Truck t : returnedTrucks)  {
            System.out.println("Truck make is " + t.getMake().toString());
            System.out.println("Truck model is " + t.getModel());
            System.out.println("Truck price is " + t.getPrice());
            System.out.println("Truck capacity is " + t.getCapacity());
            System.out.println("");
        }
    }

    @Test
    public void testGettingCheapestTruck() throws Exception {
        Truck cheapestTruck = new Truck(Manufacturer.TOYOTA, "4Runner", 12000, 2.0);

        when(truckService.getCheapestTruck()).thenReturn(cheapestTruck);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("http://localhost:8080/trucks/cheapestTruck"))
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("price").value(12000)
                );

        verify(truckService, times(1)).getCheapestTruck();
    }
}
