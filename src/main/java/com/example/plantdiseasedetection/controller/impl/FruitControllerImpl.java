package com.example.plantdiseasedetection.controller.impl;

import com.example.plantdiseasedetection.aop.CheckPermission;
import com.example.plantdiseasedetection.controller.FruitController;
import com.example.plantdiseasedetection.enums.Permission;
import com.example.plantdiseasedetection.payload.ApiResult;
import com.example.plantdiseasedetection.payload.LongNameWithValidDTO;
import com.example.plantdiseasedetection.service.FruitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FruitControllerImpl implements FruitController {

    private final FruitService fruitService;

    @CheckPermission(permissions = {Permission.ADD_FRUIT})
    @Override
    public ApiResult<?> createFruit(String name) {

        return fruitService.createFruit(name);
    }

    @CheckPermission(permissions = {Permission.GET_ALL_FRUIT})
    @Override
    public ApiResult<?> getAllFruit() {

        return fruitService.getAllFruit();
    }

    @CheckPermission(permissions = {Permission.EDIT_FRUIT})
    @Override
    public ApiResult<?> updateFruit(LongNameWithValidDTO longNameWithValidDTO) {

        return fruitService.updateFruit(longNameWithValidDTO);
    }

    @CheckPermission(permissions = {Permission.DELETE_FRUIT})
    @Override
    public ApiResult<?> deleteFruit(Long id) {

        return fruitService.deleteFruit(id);
    }


}

