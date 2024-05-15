package com.example.plantdiseasedetection.repository;

import com.example.plantdiseasedetection.entity.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TreatmentRepository extends JpaRepository<Treatment, Long> {

    Treatment findAllByLeafConditionId(Long leafConditionId);

    Boolean existsByLeafConditionId(Long leafConditionId);

    Boolean existsByLeafConditionIdAndIdNot(Long leafConditionId,Long id);
}
