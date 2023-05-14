package by.shulga.diplomaproject.dto;

import lombok.Data;

@Data
public class CarDTO {
    private Integer id;
    private String name;
    private String model;
    private String engineType;
    private int engineCapacity;
    private String body;
    private String color;
    private int releaseYear;
    private int price;
}
