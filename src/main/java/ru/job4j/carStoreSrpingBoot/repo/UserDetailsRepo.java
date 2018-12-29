package ru.job4j.carStoreSrpingBoot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.carStoreSrpingBoot.model.User;

public interface UserDetailsRepo extends JpaRepository<User, String> {
}