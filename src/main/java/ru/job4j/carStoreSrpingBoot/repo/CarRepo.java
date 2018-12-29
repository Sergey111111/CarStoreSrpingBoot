package ru.job4j.carStoreSrpingBoot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.carStoreSrpingBoot.model.Car;

import java.util.Optional;

public interface CarRepo extends JpaRepository<Car, Long> {
    Optional<Car> findById(Long id);
}
