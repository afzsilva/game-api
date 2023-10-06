package com.afzdev.gameapi.services.impl;

import com.afzdev.gameapi.dto.GameDTO;
import com.afzdev.gameapi.entities.Game;
import com.afzdev.gameapi.mapper.GameMapper;
import com.afzdev.gameapi.repository.GameRepository;
import com.afzdev.gameapi.services.GameService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Transactional
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    private final GameMapper gameMapper;

    @Override
    public GameDTO salvarGame(GameDTO gameDTO) {
        Game game = gameMapper.toGame(gameDTO);
        return gameMapper.toGameDTO(gameRepository.save(game));
    }

    @Override
    public GameDTO atualizarGame(Long id, GameDTO gameDTO) {
       Game gameRetornado = gameRepository.findById(id).orElseThrow(()-> new RuntimeException("Game não existente"));
       gameRetornado = gameMapper.toGame(gameDTO);
       gameRetornado.setId(id);
        return gameMapper.toGameDTO(gameRepository.save(gameRetornado));
    }

    @Override
    public void deletarGamePorId(Long id) {
        if (Objects.nonNull(id)){
            gameRepository.deleteById(id);
        }
    }

    @Override
    public List<GameDTO> listarTodos() {
        return gameMapper.toGameDtoList(gameRepository.findAll());
    }

    @Override
    public GameDTO buscarGamePorId(Long id) {
        return gameMapper.toGameDTO(gameRepository.findById(id).orElseThrow(()-> new RuntimeException("Game não existente")));
    }
}
