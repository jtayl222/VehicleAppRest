package com.example.vehicle.datamodel;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@lombok.Getter
@lombok.Setter
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME, 
  include = JsonTypeInfo.As.PROPERTY, 
  property = "vehicleType",
  visible = true)
@JsonSubTypes({ 
  @Type(value = Car.class, name = "Car"), 
  @Type(value = Truck.class, name = "Truck") 
})
public class Vehicle {
    private String color;
    private Integer vehicleId;
    private Boolean overloaded = false;
    private String vehicleType;
}