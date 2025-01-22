package org.eduardoconte.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long car_id;
    private String name;
    private String model;
    private String brand;
    private BigDecimal referencePrice;
    private Integer year;

    public Car(String name, String model, String brand, BigDecimal referencePrice, Integer year) {
        this.name= name;
        this.model = model;
        this.brand = brand;
        this.referencePrice = referencePrice;
        this.year = year;
    }
}
