package com.example.vehicle;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import com.example.vehicle.datamodel.Vehicle;

@Path("/")
@ApplicationScoped
public class VehicleRESTEndpoint {
    Logger log = LoggerFactory.getLogger(VehicleRESTEndpoint.class);

    @Inject
    @RestClient
    VehicleRESTServiceItf vehicleRESTServiceItf;
    
    @POST
    @Path("/get-overloaded-vehicles")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vehicle> getOverloadedVehicles(List<Vehicle> vehicles){
        log.info("getOverloadedVehicles()");
        return vehicleRESTServiceItf.getOverloadedVehicles(vehicles);
    } 
}
