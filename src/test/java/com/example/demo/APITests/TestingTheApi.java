package com.example.demo.APITests;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestingTheApi {
    HttpClient client;
    long carId;

    @Test
    public void testGetAllCars() throws IOException {
        String userName = "BackpackTrainer";

        HttpUriRequest request = new HttpGet("https://api.github.com/users/" + userName);
        client = HttpClientBuilder.create().build();
        HttpResponse response;
        response = client.execute(request);
        assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        }
    }
