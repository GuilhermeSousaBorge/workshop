package com.mechanic.workshop.repository;

import com.mechanic.workshop.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PartRepository extends JpaRepository<Part, Long> {

}
