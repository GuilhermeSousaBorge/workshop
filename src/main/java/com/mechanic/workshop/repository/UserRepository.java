package com.mechanic.workshop.repository;

import com.mechanic.workshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
