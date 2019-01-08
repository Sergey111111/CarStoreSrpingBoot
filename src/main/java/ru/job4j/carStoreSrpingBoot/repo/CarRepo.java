package ru.job4j.carStoreSrpingBoot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.carStoreSrpingBoot.model.Car;

public interface CarRepo extends JpaRepository<Car, Long> {
}
