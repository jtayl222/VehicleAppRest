package com.example.vehicle;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.example.vehicle.datamodel.Vehicle;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey="vehicle-decision-service")
@ApplicationScoped
@Path("/")
public interface VehicleRESTServiceItf {
    @POST
    @Path("/get-overloaded-vehicles")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vehicle> getOverloadedVehicles(List<Vehicle> vehicles);
}