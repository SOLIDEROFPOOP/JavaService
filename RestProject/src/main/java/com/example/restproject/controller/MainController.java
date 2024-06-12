package com.example.restproject.controller;

import com.example.restproject.entity.Cat;
import com.example.restproject.repository.CatRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    private CatRepository catRepository;
    Logger log = LoggerFactory.getLogger(MainController.class);

    @PostMapping("/api/add")
    public void addCat(@RequestBody Cat cat){
        log.info("New row " + catRepository.save(cat));
    }
}
