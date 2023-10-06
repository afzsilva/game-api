package com.afzdev.gameapi.services.impl;

import com.afzdev.gameapi.dto.CategoryDTO;
import com.afzdev.gameapi.entities.Category;
import com.afzdev.gameapi.mapper.CategoryMapper;
import com.afzdev.gameapi.repository.CategoryRepository;
import com.afzdev.gameapi.services.CategoryService;
import com.afzdev.gameapi.services.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private CategoryMapper mapper;
    @Override
    public List<CategoryDTO> listarTodas() {
        return mapper.toCategoryDtoList(categoryRepository.findAll());
    }

    @Override
    public CategoryDTO buscarCategoryPorId(Long id) {
        return mapper.toCategoryDTO(categoryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Categoria Inexistente")));
    }

    @Override
    public CategoryDTO salvarCategory(CategoryDTO categoryDTO) {
        return mapper.toCategoryDTO(categoryRepository.save(mapper.toCategory(categoryDTO)));
    }

    @Override
    public void deleteCategory(Long id) {
        if (Objects.nonNull(id)){
            categoryRepository.deleteById(id);
        }
    }

    @Override
    public void updateCategory(Long id, CategoryDTO categoryDTO) {
        if (Objects.nonNull(id)){
           Category categoryRetornada = categoryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Categoria Inexistente"));
           categoryRetornada = mapper.toCategory(categoryDTO);
           categoryRetornada.setId(id);
           categoryRepository.save(categoryRetornada);
        }
    }
}
