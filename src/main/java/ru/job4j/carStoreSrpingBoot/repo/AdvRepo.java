package ru.job4j.carStoreSrpingBoot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.carStoreSrpingBoot.model.Adv;

public interface AdvRepo extends JpaRepository<Adv, Long> {
}
