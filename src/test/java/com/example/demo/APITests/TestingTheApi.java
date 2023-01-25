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


//
//     String USER_AGENT = "Mozilla/5.0";
//
//      String GET_URL = "https://localhost:9090/SpringMVCExample";
//
//      String POST_URL = "https://localhost:9090/SpringMVCExample/home";
//
//      String POST_PARAMS = "userName=Pankaj";
//
//    public void testingLocalHostSendGet() throws IOException {
//
//        URL obj = new URL(GET_URL);
//            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//            con.setRequestMethod("GET");
//            con.setRequestProperty("User-Agent", USER_AGENT);
//            int responseCode = con.getResponseCode();
//            System.out.println("GET Response Code :: " + responseCode);
//            if (responseCode == HttpURLConnection.HTTP_OK) { // success
//                BufferedReader in = new BufferedReader(new InputStreamReader(
//                        con.getInputStream()));
//                String inputLine;
//                StringBuffer response = new StringBuffer();
//
//                while ((inputLine = in.readLine()) != null) {
//                    response.append(inputLine);
//                }
//                in.close();
//
//                // print result
//                System.out.println(response.toString());
//            } else {
//                System.out.println("GET request not worked");
//            }
//        }
    }
