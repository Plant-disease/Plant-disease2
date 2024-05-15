package com.example.plantdiseasedetection.controller;


import com.example.plantdiseasedetection.payload.ApiResult;
import com.example.plantdiseasedetection.payload.LongNameWithValidDTO;
import com.example.plantdiseasedetection.utils.RestConstants;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequestMapping(FruitController.FRUIT_CONTROLLER)
public interface FruitController {

    String FRUIT_CONTROLLER = RestConstants.BASE_PATH_V1 + "/fruit";
    String CREATE_FRUIT = "/create";
    String GET_ALL_FRUIT = "/get-all";
    String UPDATE_FRUIT = "/update";
    String DELETE_FRUIT = "/delete";


    @PostMapping(CREATE_FRUIT)
    ApiResult<?> createFruit(@RequestParam String name);

    @GetMapping(GET_ALL_FRUIT)
    ApiResult<?> getAllFruit();

    @PutMapping(UPDATE_FRUIT)
    ApiResult<?> updateFruit(@Valid @RequestBody LongNameWithValidDTO longNameWithValidDTO);

    @DeleteMapping(DELETE_FRUIT)
    ApiResult<?> deleteFruit(@RequestParam Long id);
}

