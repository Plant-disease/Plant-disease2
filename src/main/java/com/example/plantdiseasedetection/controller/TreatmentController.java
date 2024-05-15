package com.example.plantdiseasedetection.controller;


import com.example.plantdiseasedetection.payload.ApiResult;
import com.example.plantdiseasedetection.payload.CreateTreatmentDTO;
import com.example.plantdiseasedetection.payload.UpdateTreatmentDTO;
import com.example.plantdiseasedetection.utils.RestConstants;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequestMapping(TreatmentController.TREATMENT_CONTROLLER)
public interface TreatmentController {

    String TREATMENT_CONTROLLER = RestConstants.BASE_PATH_V1 + "/treatment";
    String CREATE_TREATMENT = "/create";
    String GET_ALL_TREATMENT = "/get-all";
    String UPDATE_TREATMENT = "/update";
    String DELETE_TREATMENT = "/delete";


    @PostMapping(CREATE_TREATMENT)
    ApiResult<?> createTreatment(@Valid @RequestBody CreateTreatmentDTO createTreatmentDTO);

    @GetMapping(GET_ALL_TREATMENT)
    ApiResult<?> getAllTreatment();

    @PutMapping(UPDATE_TREATMENT)
    ApiResult<?> updateTreatment(@Valid @RequestBody UpdateTreatmentDTO updateTreatmentDTO);

    @DeleteMapping(DELETE_TREATMENT)
    ApiResult<?> deleteTreatment(@RequestParam Long id);
}

