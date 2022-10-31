package com.example.vehicle.datamodel;
@lombok.Getter
@lombok.Setter
@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Car extends Vehicle {
    private Integer currentPassengers;
    private Integer maxPassengers;
}
