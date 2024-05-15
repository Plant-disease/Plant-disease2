package com.example.plantdiseasedetection.controller.impl;

import com.example.plantdiseasedetection.aop.CheckPermission;
import com.example.plantdiseasedetection.controller.DiseaseController;
import com.example.plantdiseasedetection.enums.Permission;
import com.example.plantdiseasedetection.payload.ApiResult;
import com.example.plantdiseasedetection.payload.LongNameWithValidDTO;
import com.example.plantdiseasedetection.service.DiseaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DiseaseControllerImpl implements DiseaseController {

    private final DiseaseService diseaseService;


    @CheckPermission(permissions = {Permission.ADD_DISEASE})
    @Override
    public ApiResult<?> createDisease(String name) {
        return diseaseService.createDisease(name);
    }

    @CheckPermission(permissions = {Permission.GET_ALL_DISEASE})
    @Override
    public ApiResult<?> getAllDisease() {
        return diseaseService.getAllDisease();
    }

    @CheckPermission(permissions = {Permission.EDIT_DISEASE})
    @Override
    public ApiResult<?> updateDisease(LongNameWithValidDTO longNameWithValidDTO) {
        return diseaseService.updateDisease(longNameWithValidDTO);
    }

    @CheckPermission(permissions = {Permission.DELETE_DISEASE})
    @Override
    public ApiResult<?> deleteDisease(Long id) {
        return diseaseService.deleteDisease(id);
    }
}

