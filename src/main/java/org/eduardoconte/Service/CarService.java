package org.eduardoconte.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.eduardoconte.DTO.UpdateCarDTO;
import org.eduardoconte.Entity.Car;
import org.eduardoconte.Repository.CarRepository;

@ApplicationScoped
public class CarService {

    @Inject CarRepository carRepository;

    @Inject VerificationService verificationService;

    @Transactional
    public Response listAll(){
        return Response.status(Response.Status.OK).entity(carRepository.listAll()).build();
    }


    @Transactional
    public Car listFindById(Long id){
        return verificationService.ValidationCarFindById(id);
    }


    @Transactional
    public Response createCar(Car car){
        return carRepository.createCar(car);
    }


    @Transactional
    public Response updateCar(UpdateCarDTO updateCarDTO){

        Car car = verificationService.ValidationCarFindById(updateCarDTO.getCar_id());

        Car newCar = new Car(updateCarDTO.getName(),
                updateCarDTO.getModel(),
                updateCarDTO.getBrand(),
                updateCarDTO.getReferencePrice(),
                updateCarDTO.getYear());
        newCar.setCar_id(car.getCar_id());

        return carRepository.updateCar(newCar);
    }

    @Transactional
    public Response deleteCarFindById(Long id){
        Car car = verificationService.ValidationCarFindById(id);
        return carRepository.deleteCar(car);
    }
}
