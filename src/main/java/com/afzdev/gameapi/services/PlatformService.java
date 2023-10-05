package com.afzdev.gameapi.services;

import com.afzdev.gameapi.dto.PlatformDTO;

import java.util.List;

public interface PlatformService {

    List<PlatformDTO> listarTodas();
    PlatformDTO buscarPlatformPorId(Long id);
    PlatformDTO salvarPlatform(PlatformDTO platformDTO);
    void deletePlatform(Long id);
    void updatePlaform(Long id, PlatformDTO platformDTO);

}

