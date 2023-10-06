package com.afzdev.gameapi.mapper;

import com.afzdev.gameapi.dto.CategoryDTO;
import com.afzdev.gameapi.entities.Category;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryMapper {

    private final ModelMapper mapper;

    public CategoryDTO toCategoryDTO(Category category){
        return mapper.map(category, CategoryDTO.class);
    }

    public List<CategoryDTO> toCategoryDtoList(List<Category> categoryDTOList){
        return categoryDTOList.stream().map(category -> mapper.map(category,CategoryDTO.class)).toList();
    }

    public Category toCategory(CategoryDTO categoryDTO){
        return mapper.map(categoryDTO, Category.class);
    }
}
