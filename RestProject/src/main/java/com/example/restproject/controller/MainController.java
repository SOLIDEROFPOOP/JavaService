package com.example.restproject.controller;

import com.example.restproject.dto.CatDTO;
import com.example.restproject.entity.Cat;
import com.example.restproject.repository.CatRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "main_methods")
public class MainController {
    @Autowired
    private CatRepository catRepository;
    Logger log = LoggerFactory.getLogger(MainController.class);
    @Operation(
            summary = "adds cat into db",
            description = "gets DTO of cat and using builder adds entity into db"
    )
    @PostMapping("/api/add")
    public void addCat(@RequestBody CatDTO cat){
        log.info("New row " + catRepository.save(Cat.builder()
                .age(cat.getAge())
                .weight(cat.getWeight())
                .name(cat.getName())
                .build()
        ));
    }
    @SneakyThrows
    @GetMapping("/api/all")
    public List<Cat> getAll(){
        return catRepository.findAll();
    }

    @GetMapping
    public Cat get(@RequestParam int id){
        return catRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("/api")
    public void deleteCat(@RequestParam int id){
        catRepository.deleteById(id);
    }
    @PutMapping
    public String changeCat(@RequestBody Cat cat){
        if (!catRepository.existsById(cat.getId())){
            return "no such cat";
        }
        return catRepository.save(cat).toString();
    }
}
