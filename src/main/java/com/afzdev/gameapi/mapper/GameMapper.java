package com.afzdev.gameapi.mapper;

import com.afzdev.gameapi.dto.GameDTO;
import com.afzdev.gameapi.dto.PlatformDTO;
import com.afzdev.gameapi.entities.Game;
import com.afzdev.gameapi.entities.Platform;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GameMapper {

    private final ModelMapper mapper;

    public GameDTO toGameDTO(Game game){
        return mapper.map(game, GameDTO.class);
    }

    public List<GameDTO> toGameDtoList(List<Game> gameDTOList){
        return gameDTOList.stream().map(game -> mapper.map(game, GameDTO.class)).toList();
    }

    public Game toGame(GameDTO gameDTO){
        return mapper.map(gameDTO, Game.class);
    }
}
