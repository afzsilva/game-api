package com.afzdev.gameapi.services.impl;

import com.afzdev.gameapi.dto.PlatformDTO;
import com.afzdev.gameapi.entities.Platform;
import com.afzdev.gameapi.mapper.PlatformMapper;
import com.afzdev.gameapi.repository.PlatformRepository;
import com.afzdev.gameapi.services.PlatformService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class PlatformServiceImpl implements PlatformService {

    private PlatformRepository platformRepository;

    private PlatformMapper mapper;

    @Override
    public List<PlatformDTO> listarTodas() {
        return mapper.toPlatformDtoList(platformRepository.findAll());
    }

    @Override
    public PlatformDTO buscarPlatformPorId(Long id) {
        return mapper.toPlatformDTO(platformRepository.findById(id).orElseThrow(()-> new RuntimeException("Platform não existe na base")));
    }

    @Override
    public PlatformDTO salvarPlatform(PlatformDTO platformDTO) {
       Platform platform = mapper.toPlatform(platformDTO);
        return mapper.toPlatformDTO(platformRepository.save(platform));
    }

    @Override
    public void deletePlatform(Long id) {
        platformRepository.deleteById(id);
    }

    @Override
    public void updatePlaform(Long id, PlatformDTO platformDTO) {
        Platform platformRetornada = platformRepository.findById(id).orElseThrow(()->new RuntimeException("Platform não existe na base"));
        platformRetornada = mapper.toPlatform(platformDTO);
        platformRetornada.setId(id);
        platformRepository.save(platformRetornada);
    }

}
