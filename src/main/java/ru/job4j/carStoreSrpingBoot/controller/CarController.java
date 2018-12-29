package ru.job4j.carStoreSrpingBoot.controller;

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
        //todo check other fields if necessary
        carRepo.save(car);
        return car;
    }
}
