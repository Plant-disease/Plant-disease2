package com.example.plantdiseasedetection.controller;


import com.example.plantdiseasedetection.payload.ApiResult;
import com.example.plantdiseasedetection.payload.CreateLeafDataDTO;
import com.example.plantdiseasedetection.payload.CheckDiseaseDTO;
import com.example.plantdiseasedetection.utils.RestConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@RequestMapping(LeafDataController.LEAF_DATA_CONTROLLER)
public interface LeafDataController {

    String LEAF_DATA_CONTROLLER = RestConstants.BASE_PATH_V1 + "/leaf";
    String SAVE_LEAF_DATA = "/create-leaf-data";
    String DOWNLOAD_EXCEL = "/download-excel";
    String CHECK_DISEASE_BY_KNN = "/check-disease-by-knn";


    @PostMapping(SAVE_LEAF_DATA)
    ApiResult<?> createLeafData(@Valid @RequestBody CreateLeafDataDTO createLeafDataDTO);

    @PostMapping(CHECK_DISEASE_BY_KNN)
    ApiResult<?> checkDiseaseByKNN(@Valid @RequestBody CheckDiseaseDTO checkDiseaseDTO);

    @GetMapping(DOWNLOAD_EXCEL)
    ResponseEntity<?> downloadExcel();

}

