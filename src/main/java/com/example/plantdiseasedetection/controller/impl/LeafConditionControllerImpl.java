package com.example.plantdiseasedetection.controller.impl;

import com.example.plantdiseasedetection.aop.CheckPermission;
import com.example.plantdiseasedetection.controller.LeafConditionController;
import com.example.plantdiseasedetection.enums.Permission;
import com.example.plantdiseasedetection.payload.ApiResult;
import com.example.plantdiseasedetection.payload.LongNameWithValidDTO;
import com.example.plantdiseasedetection.service.LeafConditionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LeafConditionControllerImpl implements LeafConditionController {

    private final LeafConditionService leafConditionService;

    @CheckPermission(permissions = {Permission.ADD_LEAF_CONDITION})
    @Override
    public ApiResult<?> createLeafCondition(String name) {

        return leafConditionService.createLeafCondition(name);
    }

    @CheckPermission(permissions = {Permission.GET_ALL_LEAF_CONDITION})
    @Override
    public ApiResult<?> getAllLeafCondition() {

        return leafConditionService.getAllLeafCondition();
    }

    @CheckPermission(permissions = {Permission.EDIT_LEAF_CONDITION})
    @Override
    public ApiResult<?> updateLeafCondition(LongNameWithValidDTO longNameWithValidDTO) {

        return leafConditionService.updateLeafCondition(longNameWithValidDTO);
    }

    @CheckPermission(permissions = {Permission.DELETE_LEAF_CONDITION})
    @Override
    public ApiResult<?> deleteLeafCondition(Long id) {

        return leafConditionService.deleteLeafCondition(id);
    }


}

