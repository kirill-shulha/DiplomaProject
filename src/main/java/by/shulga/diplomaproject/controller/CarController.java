package by.shulga.diplomaproject.controller;

import by.shulga.diplomaproject.entity.CarEntity;
import by.shulga.diplomaproject.response.ApiResponse;
import by.shulga.diplomaproject.service.CarService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
@SecurityRequirement(name = "JWT")
public class CarController {
    private final CarService carService;

    @GetMapping()
    public ResponseEntity<List<CarEntity>> getCar(){
        List<CarEntity> body = carService.findAll();
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity<ApiResponse> createCarEntity (@Valid @RequestBody CarEntity carEntity){
        if ((carService.findByName(carEntity.getName())).isPresent()){
            return new ResponseEntity<>(new ApiResponse(false,
                    "car already exists"), HttpStatus.CONFLICT);
        }
        carService.save(carEntity);
        return new ResponseEntity<>(new ApiResponse(true,
                "created the car"), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    ResponseEntity<ApiResponse> updateCarEntity
            (@PathVariable ("id") Integer id, @Valid @RequestBody CarEntity carEntity){
        if ((carService.findById(id)).isPresent()) {
            carService.save(id, carEntity);
            return new ResponseEntity<>(new ApiResponse(true,
                    "updated car entity"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse(false,
                "car entity does not exist"), HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteCarEntity(@PathVariable(value = "id") Long carId) {
        return ResponseEntity.ok(carId);
    }
}
