package com.example.plantdiseasedetection.controller.impl;

import com.example.plantdiseasedetection.aop.CheckPermission;
import com.example.plantdiseasedetection.controller.LeafDataController;
import com.example.plantdiseasedetection.enums.Permission;
import com.example.plantdiseasedetection.payload.ApiResult;
import com.example.plantdiseasedetection.payload.CreateLeafDataDTO;
import com.example.plantdiseasedetection.payload.CheckDiseaseDTO;
import com.example.plantdiseasedetection.service.LeafDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class LeafDataControllerImpl implements LeafDataController {

    private final LeafDataService leafDataService;

    @CheckPermission(permissions = {Permission.ADD_LEAF_DATA})
    @Override
    public ApiResult<?> createLeafData(CreateLeafDataDTO createLeafDataDTO) {
        return leafDataService.createLeafData(createLeafDataDTO);
    }

    @CheckPermission(permissions = {Permission.CHECK_LEAF_DISEASE_BY_KNN})
    @Override
    public ApiResult<?> checkDiseaseByKNN(CheckDiseaseDTO checkDiseaseDTO) {
        return leafDataService.checkDiseaseByKNN(checkDiseaseDTO);
    }

    @CheckPermission(permissions = {Permission.DOWNLOAD_EXCEL})
    @Override
    public ResponseEntity<?> downloadExcel() {
        return leafDataService.downloadExcel();
    }
}

