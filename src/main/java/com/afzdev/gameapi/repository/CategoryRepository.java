package com.afzdev.gameapi.repository;

import com.afzdev.gameapi.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
