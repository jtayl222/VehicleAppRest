package com.example.vehicle.datamodel;
@lombok.Getter
@lombok.Setter
@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Truck extends Vehicle { 
    private Integer currentCargoWeight;
    private Integer maxCargoWeight;
}
