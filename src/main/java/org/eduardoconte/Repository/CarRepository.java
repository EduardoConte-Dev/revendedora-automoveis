package org.eduardoconte.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import org.eduardoconte.Entity.Car;
import org.eduardoconte.Exception.ConstraintViolationException;
import org.eduardoconte.Exception.PersistenceException;

@ApplicationScoped
public class CarRepository implements PanacheRepository<Car> {

    public Response createCar(Car car){
        try {
            persist(car);
            return Response.status(Response.Status.OK).entity("Carro salvo com sucesso!").build();
        } catch (Exception e) {
            throw new PersistenceException("Erro ao salvar registro!");
        }
    }

    public Response updateCar(Car car){
        try {
            getEntityManager().merge(car);
            return Response.status(Response.Status.OK).entity("Carro atualizado com sucesso!").build();
        } catch (Exception e) {
            throw new PersistenceException("Erro ao salvar registro!");
        }
    }

    public Response deleteCar(Car car){
        try {
            delete(car);
            return Response.status(Response.Status.OK).entity("Carro deletado com sucesso!").build();
        } catch (Exception e) {
            throw new ConstraintViolationException("Erro ao remover registro!");
        }
    }
}
