package com.afzdev.gameapi.services;

import com.afzdev.gameapi.dto.CategoryDTO;
import com.afzdev.gameapi.dto.DeveloperDTO;

import java.util.List;

public interface DeveloperService {

    List<DeveloperDTO> listarTodos();
    DeveloperDTO buscarDeveloperPorId(Long id);
    DeveloperDTO salvarDeveloper(DeveloperDTO developerDTO);
    void deleteDeveloper(Long id);
    void updateDeveloper(Long id, DeveloperDTO developerDTO);
}
