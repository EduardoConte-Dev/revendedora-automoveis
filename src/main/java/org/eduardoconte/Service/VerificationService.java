package org.eduardoconte.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eduardoconte.Entity.Car;
import org.eduardoconte.Exception.NotExistArgumentException;
import org.eduardoconte.Repository.CarRepository;

@ApplicationScoped
public class VerificationService {

    @Inject
    CarRepository carRepository;

    public Car ValidationCarFindById(Long id){
        Car car = carRepository.findById(id);
        if (car == null){
            throw new NotExistArgumentException("Carro com ID: " + id + " não existe!");
        }
        return car;
    }
}
