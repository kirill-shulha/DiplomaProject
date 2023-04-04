package by.shulga.diplomaproject.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;


import java.io.Serializable;

@Entity
@Table(name = "cars")
@NoArgsConstructor
public class CarEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "category_name")
    private Integer id;
    private String name;
    private String model;
    @Column(name = "engine_type")
    private String engineType;

    @Column(name = "engine_capacity")
    private int engineCapacity;
    private String body;
    private String color;
    @Column(name = "release_year")
    private int releaseYear;
    private int price;

    public CarEntity (String name, String model, String engineType,
                      int engineCapacity, String body, String color,
                      int releaseYear,int price){
        this.name = name;
        this.model = model;
        this.engineType = engineType;
        this.engineCapacity = engineCapacity;
        this.body = body;
        this.color = color;
        this.releaseYear = releaseYear;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CarEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", engineType='" + engineType + '\'' +
                ", engineCapacity=" + engineCapacity +
                ", body='" + body + '\'' +
                ", color='" + color + '\'' +
                ", releaseYear=" + releaseYear +
                ", price=" + price +
                '}';
    }
}
