package ru.job4j.carStoreSrpingBoot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.carStoreSrpingBoot.model.CarPic;

import java.util.List;
import java.util.Optional;

public interface PicRepo extends JpaRepository<CarPic, Long> {
}
