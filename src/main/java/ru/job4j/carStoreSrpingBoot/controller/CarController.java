package ru.job4j.carStoreSrpingBoot.controller;

import org.codehaus.jackson.map.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import ru.job4j.carStoreSrpingBoot.model.Car;
import ru.job4j.carStoreSrpingBoot.repo.CarRepo;

@RestController
@RequestMapping("car")
public class CarController {
    private final CarRepo carRepo;

    public CarController(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    @GetMapping("{id}")
    public Car getOne(@PathVariable("id") Long id) {
        return carRepo.findById(id).get();
    }

    @PostMapping("{id}")
    public Car create(@RequestBody Car car) {
        carRepo.save(car);
        return car;
    }
    @PutMapping("{id}")
    public Car update(@PathVariable("id") Car carFromDb, @RequestBody Car car) {
        BeanUtils.copyProperties(car, carFromDb, "id");
        return car;
    }
    @DeleteMapping("{id}")
    public  void delete(@PathVariable("id") Car car) {
        carRepo.delete(car);
    }
}
