package by.shulga.diplomaproject.entity;

import jakarta.persistence.*;


import java.io.Serializable;

@Entity
@Table(name = "cars")
public class CarEntity implements Serializable {

    private Integer id;

    @Column(name = "category_name")
    private String Name;
    private String Model;
    @Column(name = "engine_type")
    private String engineType;

    @Column(name = "engine_capacity")
    private int engineCapacity;
    private String body;
    private String color;
    @Column(name = "release_year")
    private int releaseYear;
    private int price;

    public CarEntity(){
    }
    public CarEntity (String Name, String Model, String engineType,
                      int engineCapacity, String body, String color,
                      int releaseYear,int price){
        this.Name = Name;
        this.Model = Model;
        this.engineType = engineType;
        this.engineCapacity = engineCapacity;
        this.body = body;
        this.color = color;
        this.releaseYear = releaseYear;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
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

    public void setPrice(int Price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CarEntity{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Model='" + Model + '\'' +
                ", engineType='" + engineType + '\'' +
                ", engineCapacity=" + engineCapacity +
                ", body='" + body + '\'' +
                ", color='" + color + '\'' +
                ", releaseYear=" + releaseYear +
                ", price=" + price +
                '}';
    }
}
