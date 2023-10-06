package com.afzdev.gameapi.repository;

import com.afzdev.gameapi.entities.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {
}
