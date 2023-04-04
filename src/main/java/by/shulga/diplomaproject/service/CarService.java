package by.shulga.diplomaproject.service;

import by.shulga.diplomaproject.entity.CarEntity;
import by.shulga.diplomaproject.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<CarEntity> findAll(){
        return carRepository.findAll();
    }

    public void save (CarEntity carEntity){
        carRepository.save(carEntity);
    }

    public Optional<CarEntity> findByName (String name){
        return carRepository.findByName(name);
    }

    public Optional<CarEntity> findById(Integer id){
        return carRepository.findById(id);
    }

    public void save (Integer id, CarEntity newCarEntity){
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