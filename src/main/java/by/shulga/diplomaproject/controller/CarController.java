package by.shulga.diplomaproject.controller;

import by.shulga.diplomaproject.entity.CarEntity;
import by.shulga.diplomaproject.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/")
    public ResponseEntity<List<CarEntity>> getCarEntities(){
        List<CarEntity> body = carService.carEntityList();
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @PostMapping("/create")
    ResponseEntity<ApiResponse> createCarEntity (@Valid @RequestBody CarEntity carEntity){
        if (Objects.nonNull(carService.readCarEntity(carEntity.getName()))){
            return new ResponseEntity<ApiResponse>(new ApiResponse(false,
                    "car already exists"), HttpStatus.CONFLICT);
        }
        carService.createCarEntity(carEntity);
        return new ResponseEntity<>(new ApiResponse(true,
                "created the car"), HttpStatus.CREATED);
    }
    @PostMapping("/update/{id}")
    ResponseEntity<ApiResponse> updateCarEntity
            (@PathVariable ("id") Integer id, @Valid @RequestBody CarEntity carEntity){
        if (Objects.nonNull(carService.readCarEntity(id))) {
            carService.updateCarEntity(id, carEntity);
            return new ResponseEntity<ApiResponse>(new ApiResponse(true,
                    "updated car entity"), HttpStatus.OK);
        }
        return new ResponseEntity<ApiResponse>(new ApiResponse(false, "car entity does not exist"), HttpStatus.NOT_FOUND);
    }

}
