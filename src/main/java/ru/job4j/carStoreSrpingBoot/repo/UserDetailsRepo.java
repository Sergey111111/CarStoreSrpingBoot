package ru.job4j.carStoreSrpingBoot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.carStoreSrpingBoot.model.User;

import java.util.Optional;

public interface UserDetailsRepo extends JpaRepository<User, Long> {
    Optional<User> findByGoogleId(String googleId);
}