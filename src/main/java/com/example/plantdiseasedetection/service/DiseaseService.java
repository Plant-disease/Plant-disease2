package com.example.plantdiseasedetection.service;

import com.example.plantdiseasedetection.payload.ApiResult;
import com.example.plantdiseasedetection.payload.LongNameWithValidDTO;

public interface DiseaseService {


    ApiResult<?> createDisease(String name);

    ApiResult<?> getAllDisease();

    ApiResult<?> updateDisease(LongNameWithValidDTO longNameWithValidDTO);

    ApiResult<?> deleteDisease(Long id);
}


