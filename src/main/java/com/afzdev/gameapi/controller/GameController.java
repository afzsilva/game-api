package com.afzdev.gameapi.controller;

import com.afzdev.gameapi.dto.GameDTO;
import com.afzdev.gameapi.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/game")
public class GameController {

    @Autowired
    GameService service;

    @GetMapping("/{id}")
    public ResponseEntity<GameDTO> buscarGame(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.buscarGamePorId(id));
    }

    @GetMapping
    public ResponseEntity<List<GameDTO>> listarTodosGame(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @PostMapping
    public ResponseEntity<GameDTO> salvarGame(@RequestBody GameDTO gameDTO){
        return ResponseEntity.ok(service.salvarGame(gameDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameDTO> atualizarGame(@PathVariable("id") Long id, @RequestBody GameDTO gameDTO){
        return ResponseEntity.ok(service.atualizarGame(id,gameDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarGame(@PathVariable("id") Long id){
        service.deletarGamePorId(id);
        return ResponseEntity.noContent().build();
    }
}
