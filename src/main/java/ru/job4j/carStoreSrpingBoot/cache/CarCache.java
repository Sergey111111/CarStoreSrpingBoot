package ru.job4j.carStoreSrpingBoot.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import ru.job4j.carStoreSrpingBoot.model.Car;
import ru.job4j.carStoreSrpingBoot.repo.CarRepo;

import java.util.List;

@Component
public class CarCache {


  private CarRepo carRepo;

  @Autowired
  public CarCache(CarRepo carRepo) {
    this.carRepo = carRepo;
  }

  @Cacheable(value = "carsCache", key = "#cars")
  public List<Car> findAll() {
    return carRepo.findAll();
  }

}
