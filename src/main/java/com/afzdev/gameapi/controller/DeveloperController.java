package com.afzdev.gameapi.controller;

import com.afzdev.gameapi.dto.DeveloperDTO;
import com.afzdev.gameapi.services.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/developer")
public class DeveloperController {

    @Autowired
    private DeveloperService service;


    @GetMapping
    public ResponseEntity<List<DeveloperDTO>> buscarTodasDeveloper(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity <DeveloperDTO> buscarDeveloperPorId(@PathVariable("id") Long id){
        return  ResponseEntity.ok(service.buscarDeveloperPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deleteDeveloperPorId(@PathVariable("id") Long id){
        service.deleteDeveloper(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity <Long> updateDeveloper(@PathVariable("id") Long id, @RequestBody DeveloperDTO developerDTO){
        service.updateDeveloper(id,developerDTO);
        return ResponseEntity.ok(id);
    }

    @PostMapping
    public ResponseEntity <DeveloperDTO> salvarDeveloper(@RequestBody DeveloperDTO developerDTO){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(developerDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(service.salvarDeveloper(developerDTO));
    }


}
