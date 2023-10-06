package com.afzdev.gameapi.repository;

import com.afzdev.gameapi.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Long> {

}
