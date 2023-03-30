package by.shulga.diplomaproject.repository;

import by.shulga.diplomaproject.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Integer> {
    CarEntity findByName(String name);
}
