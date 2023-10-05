package com.afzdev.gameapi.controller;

import com.afzdev.gameapi.dto.PlatformDTO;
import com.afzdev.gameapi.services.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/platform")
public class PlatformController {

    @Autowired
    private PlatformService service;


    @GetMapping
    public ResponseEntity <List<PlatformDTO>> buscarTodasPlataform(){
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity <PlatformDTO> buscarPlataformPorId(@PathVariable("id") Long id){
        return  ResponseEntity.ok(service.buscarPlatformPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deletePlataformPorId(@PathVariable("id") Long id){
        service.deletePlatform(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity <Long> updatePlataform(@PathVariable("id") Long id, @RequestBody PlatformDTO platformDTO){
        service.updatePlaform(id,platformDTO);
        return ResponseEntity.ok(id);
    }

    @PostMapping
    public ResponseEntity <PlatformDTO> salvarPlataform(@RequestBody PlatformDTO platformDTO){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(platformDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(service.salvarPlatform(platformDTO));
    }

}
