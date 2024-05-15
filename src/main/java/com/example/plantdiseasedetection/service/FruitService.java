package com.example.plantdiseasedetection.service;

import com.example.plantdiseasedetection.payload.ApiResult;
import com.example.plantdiseasedetection.payload.LongNameWithValidDTO;

public interface FruitService {


    ApiResult<?> createFruit(String name);

    ApiResult<?> getAllFruit();

    ApiResult<?> updateFruit(LongNameWithValidDTO longNameWithValidDTO);

    ApiResult<?> deleteFruit(Long id);
}


