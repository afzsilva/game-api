package com.afzdev.gameapi.mapper;

import com.afzdev.gameapi.dto.DeveloperDTO;
import com.afzdev.gameapi.entities.Developer;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DeveloperMapper {
    private final ModelMapper mapper;

    public DeveloperDTO toDeveloperDTO(Developer developer){
        return mapper.map(developer, DeveloperDTO.class);
    }

    public List<DeveloperDTO> toDeveloperDtoList(List<Developer> developerDTOList){
        return developerDTOList.stream().map(developer -> mapper.map(developer,DeveloperDTO.class)).toList();
    }

    public Developer toDeveloper(DeveloperDTO developerDTO){
        return mapper.map(developerDTO, Developer.class);
    }


}
