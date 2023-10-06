package com.afzdev.gameapi.services.impl;

import com.afzdev.gameapi.dto.DeveloperDTO;
import com.afzdev.gameapi.entities.Developer;
import com.afzdev.gameapi.mapper.DeveloperMapper;
import com.afzdev.gameapi.repository.DeveloperRepository;
import com.afzdev.gameapi.services.DeveloperService;
import com.afzdev.gameapi.services.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepository developerRepository;
    private final DeveloperMapper developerMapper;

    @Override
    public List<DeveloperDTO> listarTodos() {
        return developerMapper.toDeveloperDtoList(developerRepository.findAll());
    }

    @Override
    public DeveloperDTO buscarDeveloperPorId(Long id) {
        return developerMapper.toDeveloperDTO(developerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Fabricante do game não existente")));
    }

    @Override
    public DeveloperDTO salvarDeveloper(DeveloperDTO developerDTO) {
        return developerMapper.toDeveloperDTO(developerRepository.save(developerMapper.toDeveloper(developerDTO)));
    }

    @Override
    public void deleteDeveloper(Long id) {
        if (Objects.nonNull(id)){
            developerRepository.deleteById(id);
        }
    }

    @Override
    public void updateDeveloper(Long id, DeveloperDTO developerDTO) {
        Developer developerRetornado = developerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Fabricante do game não existente"));
        developerRetornado = developerMapper.toDeveloper(developerDTO);
        developerRetornado.setId(id);
        developerRepository.save(developerRetornado);

    }
}
