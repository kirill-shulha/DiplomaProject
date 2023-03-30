package by.shulga.diplomaproject.service;

import by.shulga.diplomaproject.entity.CarEntity;
import by.shulga.diplomaproject.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<CarEntity> carEntityList(){
        return carRepository.findAll();
    }

    public void createCarEntity(CarEntity carEntity){
        carRepository.save(carEntity);
    }

    public CarEntity readCarEntity (String Name){
        return carRepository.findByName(Name);
    }

    public Optional<CarEntity> readCarEntity(Integer id){
        return carRepository.findById(id);
    }

    public void updateCarEntity(Integer id, CarEntity newCarEntity){
        CarEntity carEntity = carRepository.findById(id).get();
        carEntity.setName(newCarEntity.getName());
        carEntity.setModel(newCarEntity.getModel());
        carEntity.setEngineType(newCarEntity.getEngineType());
        carEntity.setEngineCapacity(newCarEntity.getEngineCapacity());
        carEntity.setBody(newCarEntity.getBody());
        carEntity.setColor(newCarEntity.getColor());
        carEntity.setReleaseYear(newCarEntity.getReleaseYear());
        carEntity.setPrice(newCarEntity.getPrice());
        carRepository.save(carEntity);
    }
}