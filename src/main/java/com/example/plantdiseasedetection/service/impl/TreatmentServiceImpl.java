package com.example.plantdiseasedetection.service.impl;

import com.example.plantdiseasedetection.entity.LeafCondition;
import com.example.plantdiseasedetection.entity.Treatment;
import com.example.plantdiseasedetection.exception.RestException;
import com.example.plantdiseasedetection.payload.ApiResult;
import com.example.plantdiseasedetection.payload.CreateTreatmentDTO;
import com.example.plantdiseasedetection.payload.GetTreatmentDTO;
import com.example.plantdiseasedetection.payload.UpdateTreatmentDTO;
import com.example.plantdiseasedetection.repository.LeafConditionRepository;
import com.example.plantdiseasedetection.repository.TreatmentRepository;
import com.example.plantdiseasedetection.service.TreatmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class TreatmentServiceImpl implements TreatmentService {

    private final TreatmentRepository treatmentRepository;
    private final LeafConditionRepository leafConditionRepository;

    @Override
    public ApiResult<?> createTreatment(CreateTreatmentDTO createTreatmentDTO) {

        LeafCondition leafCondition = leafConditionRepository.findById(createTreatmentDTO.getLeafConditionId()).orElseThrow(() -> RestException.notFound("LEAF_CONDITION_ID"));

        Boolean exists = treatmentRepository.existsByLeafConditionId(createTreatmentDTO.getLeafConditionId());
        if (exists)
            throw new RestException("THIS_LEAF_CONDITION_ID_IS_ALREADY_SAVED_TO_TREATMENT", HttpStatus.BAD_REQUEST);
        else {
            Treatment treatment = new Treatment();
            treatment.setLeafCondition(leafCondition);
            treatment.setInstruction(createTreatmentDTO.getInstruction());
            Treatment save = treatmentRepository.save(treatment);
            return ApiResult.successResponse(save.getId(), "SAVED_SUCCESSFULLY");
        }

    }

    @Override
    public ApiResult<?> getAllTreatment() {

        List<Treatment> treatmentList = treatmentRepository.findAll();

        return ApiResult.successResponse(toDTO(treatmentList));
    }

    @Override
    public ApiResult<?> updateTreatment(UpdateTreatmentDTO updateTreatmentDTO) {

        Treatment treatment = treatmentRepository.findById(updateTreatmentDTO.getId()).orElseThrow(() -> RestException.notFound("TREATMENT_ID"));
        LeafCondition leafCondition = leafConditionRepository.findById(updateTreatmentDTO.getLeafConditionId()).orElseThrow(() -> RestException.notFound("LEAF_CONDITION_ID"));

        Boolean exists = treatmentRepository.existsByLeafConditionIdAndIdNot(updateTreatmentDTO.getLeafConditionId(), updateTreatmentDTO.getId());
        if (exists)
            throw new RestException("THIS_LEAF_CONDITION_ID_IS_ALREADY_SAVED_TO_TREATMENT", HttpStatus.BAD_REQUEST);
        else {
            treatment.setInstruction(updateTreatmentDTO.getInstruction());
            treatment.setLeafCondition(leafCondition);
            treatmentRepository.save(treatment);
        }

        return ApiResult.successResponse("UPDATED_SUCCESSFULLY");
    }

    @Override
    public ApiResult<?> deleteTreatment(Long id) {

        if (treatmentRepository.existsById(id))
            treatmentRepository.deleteById(id);
        else
            throw new RestException("TREATMENT_ID_NOT_FOUND", HttpStatus.NOT_FOUND);


        return ApiResult.successResponse("DELETED_SUCCESSFULLY");
    }

    public GetTreatmentDTO toDTO(Treatment treatment) {

        GetTreatmentDTO getTreatmentDTO = new GetTreatmentDTO();
        getTreatmentDTO.setId(treatment.getId());
        getTreatmentDTO.setInstruction(treatment.getInstruction());
        getTreatmentDTO.setLeafConditionId(treatment.getLeafCondition().getId());
        getTreatmentDTO.setLeafConditionName(treatment.getLeafCondition().getName());

        return getTreatmentDTO;
    }

    public List<GetTreatmentDTO> toDTO(List<Treatment> treatmentList) {

        List<GetTreatmentDTO> getTreatmentDTOList = new ArrayList<>();

        for (Treatment treatment : treatmentList) {

            getTreatmentDTOList.add(toDTO(treatment));
        }

        return getTreatmentDTOList;
    }
}

