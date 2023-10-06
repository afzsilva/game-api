package com.afzdev.gameapi.controller;

import com.afzdev.gameapi.dto.CategoryDTO;
import com.afzdev.gameapi.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService service;


    @GetMapping
    public ResponseEntity<List<CategoryDTO>> buscarTodasCategory(){
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity <CategoryDTO> buscarCategoryPorId(@PathVariable("id") Long id){
        return  ResponseEntity.ok(service.buscarCategoryPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deleteCategoryPorId(@PathVariable("id") Long id){
        service.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity <Long> updateCategory(@PathVariable("id") Long id, @RequestBody CategoryDTO categoryDTO){
        service.updateCategory(id,categoryDTO);
        return ResponseEntity.ok(id);
    }

    @PostMapping
    public ResponseEntity <CategoryDTO> salvarCategory(@RequestBody CategoryDTO categoryDTO){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(categoryDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(service.salvarCategory(categoryDTO));
    }
}
