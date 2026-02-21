package com.project.fitness_monolith.repository;

import com.project.fitness_monolith.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User findByEmail(String email);
}
