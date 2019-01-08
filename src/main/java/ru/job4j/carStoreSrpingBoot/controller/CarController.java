package ru.job4j.carStoreSrpingBoot.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.job4j.carStoreSrpingBoot.model.Car;
import ru.job4j.carStoreSrpingBoot.repo.CarRepo;
import ru.job4j.carStoreSrpingBoot.repo.UserDetailsRepo;

import java.time.LocalDateTime;
import java.util.List;

/**
 * This is REST controller witch sends to the front-end side information  using json objects
 */
@CrossOrigin
@RestController
@RequestMapping("car")
public class CarController {

  private final CarRepo carRepo;
  private final UserDetailsRepo userRepo;

  @Autowired
  public CarController(CarRepo carRepo, UserDetailsRepo userRepo) {
    this.carRepo = carRepo;
    this.userRepo = userRepo;
  }

  @GetMapping
  public List<Car> list() {
    return carRepo.findAll();
  }

  @GetMapping("{id}")
  public Car getOne(@PathVariable("id") Car car) {
    return car;
  }

  @PostMapping
  public Car create(@RequestBody Car car) {
    car.setCreationDate(LocalDateTime.now());
    return carRepo.save(car);
  }

  @PutMapping
  public Car update(@PathVariable("id") Car carFromDb, @RequestBody Car car) {
    BeanUtils.copyProperties(car, carFromDb, "id");
    return carRepo.save(carFromDb);
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable("id") Car car) {
    carRepo.delete(car);
  }


}
