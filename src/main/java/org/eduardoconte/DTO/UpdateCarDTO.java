package org.eduardoconte.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateCarDTO {

    private Long car_id;
    private String name;
    private String model;
    private String brand;
    private BigDecimal referencePrice;
    private Integer year;

}
