package com.example.plantdiseasedetection.service;

import com.example.plantdiseasedetection.payload.ApiResult;
import com.example.plantdiseasedetection.payload.CreateTreatmentDTO;
import com.example.plantdiseasedetection.payload.UpdateTreatmentDTO;

public interface TreatmentService {


    ApiResult<?> createTreatment(CreateTreatmentDTO createTreatmentDTO);

    ApiResult<?> getAllTreatment();

    ApiResult<?> updateTreatment(UpdateTreatmentDTO updateTreatmentDTO);

    ApiResult<?> deleteTreatment(Long id);
}


