package com.hackprotech.orderservice.integrationtests;

import com.hackprotech.orderservice.dto.OrderDTO;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderServiceControllerIntegrationTest {

    @LocalServerPort
    private int localPort;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @DisplayName("Integration Tests on new order process endpoint")
    public void testNewOrderProcessing() throws JSONException {

        //  JsonRequest
        JSONArray foodItems = new JSONArray();

        JSONObject foodItem1 = new JSONObject();
        foodItem1.put("foodId", 16);
        foodItem1.put("quantity", 4);
        JSONObject foodItem2 = new JSONObject();
        foodItem1.put("foodId", 12);
        foodItem1.put("quantity", 8);
        foodItems.put(foodItem1);
        foodItems.put(foodItem2);

        JSONObject jsonRequestObject = new JSONObject();
        jsonRequestObject.put("restaurantId", 114l);
        jsonRequestObject.put("modeOfPayment", "UPI");

        jsonRequestObject.put("foodItems", foodItems);


        // HTTP Headers
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        // HTTP Entity Object
        HttpEntity<String> httpRequest = new HttpEntity<>(jsonRequestObject.toString(), httpHeaders);

        // RestTemplate Client (HttpClient)
        ResponseEntity<OrderDTO> orderResponseEntity = testRestTemplate.postForEntity("/order/new-order", httpRequest, OrderDTO.class);

        assertEquals(HttpStatus.CREATED, orderResponseEntity.getStatusCode());
        assertEquals(1, orderResponseEntity.getBody().getOrderId());
        assertEquals(jsonRequestObject.getLong("restaurantId"), orderResponseEntity.getBody().getRestaurantId());
    }
}
