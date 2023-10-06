package com.afzdev.gameapi.services;

import com.afzdev.gameapi.dto.GameDTO;
import com.afzdev.gameapi.entities.Game;

import java.util.List;

public interface GameService {

    public List<GameDTO> listarTodos();
    public GameDTO buscarGamePorId(Long id);
    public GameDTO salvarGame(GameDTO gameDTO);
    public GameDTO atualizarGame(Long id, GameDTO gameDTO);

    public void deletarGamePorId(Long id);


}
