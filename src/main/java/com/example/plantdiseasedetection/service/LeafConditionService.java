package com.example.plantdiseasedetection.service;

import com.example.plantdiseasedetection.payload.ApiResult;
import com.example.plantdiseasedetection.payload.LongNameWithValidDTO;

public interface LeafConditionService {


    ApiResult<?> createLeafCondition(String name);

    ApiResult<?> getAllLeafCondition();

    ApiResult<?> updateLeafCondition(LongNameWithValidDTO longNameWithValidDTO);

    ApiResult<?> deleteLeafCondition(Long id);
}


