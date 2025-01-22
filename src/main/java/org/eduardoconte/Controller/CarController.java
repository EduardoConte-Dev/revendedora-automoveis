package org.eduardoconte.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.eduardoconte.DTO.UpdateCarDTO;
import org.eduardoconte.Entity.Car;
import org.eduardoconte.Service.CarService;

@Path("/cars")
public class CarController {

    @Inject CarService carService;

    @GET
    @Path("/listAll")
    public Response listAll(){
        return carService.listAll();
    }


    @GET
    @Path("/listId/{id}")
    public Car listFindById(Long id){
        return carService.listFindById(id);
    }


    @POST
    @Path("/createCar")
    public Response createCar(Car car){
        return carService.createCar(car);
    }


    @PUT
    @Path("/update")
    public Response updateCar(UpdateCarDTO updateCarDTO){
        return carService.updateCar(updateCarDTO);
    }


    @DELETE
    @Path("/deleteCar/{id}")
    public Response deleteCar(Long id){
        return carService.deleteCarFindById(id);
    }
}
