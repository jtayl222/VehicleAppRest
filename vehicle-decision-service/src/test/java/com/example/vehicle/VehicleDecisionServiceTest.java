package com.example.vehicle;

import org.junit.jupiter.api.Test;

import com.example.vehicle.datamodel.Car;
import com.example.vehicle.datamodel.Truck;
import com.example.vehicle.datamodel.Vehicle;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.quarkus.logging.Log;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.with;

@QuarkusTest
public class VehicleDecisionServiceTest {
    @Test
    public void testHelloEndpoint() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        
        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle car = Car.builder()
            .currentPassengers(3)
            .maxPassengers(4)
            .build();
        car.setVehicleId(22);
        car.setVehicleType("Car");
        vehicles.add(car);

        Vehicle truck = Truck.builder()
            .currentCargoWeight(400)
            .maxCargoWeight(300)
            .build();
        truck.setVehicleId(33);
        truck.setVehicleType("Truck");
        vehicles.add(truck);
        
        String postRequest = 
              "{\"vehicleInstances\":"
            + objectMapper.writeValueAsString(vehicles)
            + "}";
        Log.info(postRequest);

        with()
          .when()
            .body(postRequest)
            .accept(ContentType.JSON)
            .contentType(ContentType.JSON)
          .post("/get-overloaded-vehicles")
          .then()
             .statusCode(200)
             //.body(is("hello world!"))
             ;
    }
}