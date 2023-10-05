package com.afzdev.gameapi.mapper;

import com.afzdev.gameapi.dto.PlatformDTO;
import com.afzdev.gameapi.entities.Platform;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PlatformMapper {

    private final ModelMapper mapper;

    public PlatformDTO toPlatformDTO(Platform platform){
        return mapper.map(platform, PlatformDTO.class);
    }

    public List<PlatformDTO> toPlatformDtoList(List<Platform> platformDTOList){
        return platformDTOList.stream().map(platform -> mapper.map(platform,PlatformDTO.class)).toList();
    }

    public Platform toPlatform(PlatformDTO platformDTO){
        return mapper.map(platformDTO, Platform.class);
    }
}
