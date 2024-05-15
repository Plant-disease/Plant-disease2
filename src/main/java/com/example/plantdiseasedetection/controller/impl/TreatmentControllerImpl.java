package com.example.plantdiseasedetection.controller.impl;

import com.example.plantdiseasedetection.aop.CheckPermission;
import com.example.plantdiseasedetection.controller.TreatmentController;
import com.example.plantdiseasedetection.enums.Permission;
import com.example.plantdiseasedetection.payload.ApiResult;
import com.example.plantdiseasedetection.payload.CreateTreatmentDTO;
import com.example.plantdiseasedetection.payload.UpdateTreatmentDTO;
import com.example.plantdiseasedetection.service.TreatmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TreatmentControllerImpl implements TreatmentController {

    private final TreatmentService treatmentService;

    @CheckPermission(permissions = {Permission.ADD_TREATMENT})
    @Override
    public ApiResult<?> createTreatment(CreateTreatmentDTO createTreatmentDTO) {

        return treatmentService.createTreatment(createTreatmentDTO);
    }

    @CheckPermission(permissions = {Permission.GET_ALL_TREATMENT})
    @Override
    public ApiResult<?> getAllTreatment() {

        return treatmentService.getAllTreatment();
    }

    @CheckPermission(permissions = {Permission.EDIT_TREATMENT})
    @Override
    public ApiResult<?> updateTreatment(UpdateTreatmentDTO updateTreatmentDTO) {

        return treatmentService.updateTreatment(updateTreatmentDTO);
    }

    @CheckPermission(permissions = {Permission.DELETE_TREATMENT})
    @Override
    public ApiResult<?> deleteTreatment(Long id) {

        return treatmentService.deleteTreatment(id);
    }


}

