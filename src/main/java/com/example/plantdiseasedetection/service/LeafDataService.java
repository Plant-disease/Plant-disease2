package com.example.plantdiseasedetection.service;

import com.example.plantdiseasedetection.payload.ApiResult;
import com.example.plantdiseasedetection.payload.CreateLeafDataDTO;
import com.example.plantdiseasedetection.payload.CheckDiseaseDTO;
import org.springframework.http.ResponseEntity;


public interface LeafDataService {

    ApiResult<?> createLeafData(CreateLeafDataDTO createLeafDataDTO);

    ApiResult<?> checkDiseaseByKNN(CheckDiseaseDTO checkDiseaseDTO);

    ResponseEntity<?> downloadExcel();
}


