package com.afzdev.gameapi.services;

import com.afzdev.gameapi.dto.CategoryDTO;
import com.afzdev.gameapi.dto.PlatformDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> listarTodas();
    CategoryDTO buscarCategoryPorId(Long id);
    CategoryDTO salvarCategory(CategoryDTO categoryDTO);
    void deleteCategory(Long id);
    void updateCategory(Long id, CategoryDTO categoryDTO);
}
