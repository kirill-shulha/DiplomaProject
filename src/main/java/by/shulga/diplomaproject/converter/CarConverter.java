package by.shulga.diplomaproject.converter;

import by.shulga.diplomaproject.dto.CarDTO;
import by.shulga.diplomaproject.entity.CarEntity;
import org.springframework.stereotype.Component;

@Component
public class CarConverter {
    public CarEntity convert (CarDTO carDTO){
        CarEntity carEntity = new CarEntity();
        carEntity.setId(carDTO.getId());
        carEntity.setName(carDTO.getName());
        carEntity.setModel(carDTO.getModel());
        carEntity.setEngineType(carDTO.getEngineType());
        carEntity.setEngineCapacity(carDTO.getEngineCapacity());
        carEntity.setBody(carDTO.getBody());
        carEntity.setColor(carDTO.getColor());
        carEntity.setReleaseYear(carDTO.getReleaseYear());
        carEntity.setPrice(carDTO.getPrice());
        return carEntity;
    }
    public CarDTO convert (CarEntity carEntity){
        CarDTO carDTO = new CarDTO();
        carDTO.setId(carEntity.getId());
        carDTO.setName(carEntity.getName());
        carDTO.setModel(carEntity.getModel());
        carDTO.setEngineType(carEntity.getEngineType());
        carDTO.setEngineCapacity(carEntity.getEngineCapacity());
        carDTO.setBody(carEntity.getBody());
        carDTO.setColor(carEntity.getColor());
        carDTO.setReleaseYear(carEntity.getReleaseYear());
        carDTO.setPrice(carEntity.getPrice());
        return carDTO;
    }
}
