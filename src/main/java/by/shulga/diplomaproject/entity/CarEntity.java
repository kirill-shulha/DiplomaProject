package by.shulga.diplomaproject.entity;

import jakarta.persistence.*;


import java.io.Serializable;

@Entity
@Table(name = "Cars")
public class CarEntity implements Serializable {

    private int id;

    @Column(name = "category_name")
    private String carName;
    private String carModel;
    private String engineType;
    private int engineCapacity;
    private String bodyCar;
    private String color;
    private int releaseYear;
    private int carPrice;

    public CarEntity(){
    }
    public CarEntity (String carName, String carModel, String engineType,
                      int engineCapacity, String bodyCar, String color,
                      int releaseYear,int carPrice){
        this.carName = carName;
        this.carModel = carModel;
        this.engineType = engineType;
        this.engineCapacity = engineCapacity;
        this.bodyCar = bodyCar;
        this.color = color;
        this.releaseYear = releaseYear;
        this.carPrice = carPrice;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
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

    public String getBodyCar() {
        return bodyCar;
    }

    public void setBodyCar(String bodyCar) {
        this.bodyCar = bodyCar;
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

    public int getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(int carPrice) {
        this.carPrice = carPrice;
    }

    @Override
    public String toString() {
        return "CarEntity{" +
                "id=" + id +
                ", carName='" + carName + '\'' +
                ", carModel='" + carModel + '\'' +
                ", engineType='" + engineType + '\'' +
                ", engineCapacity=" + engineCapacity +
                ", bodyCar='" + bodyCar + '\'' +
                ", color='" + color + '\'' +
                ", releaseYear=" + releaseYear +
                ", carPrice=" + carPrice +
                '}';
    }
}
