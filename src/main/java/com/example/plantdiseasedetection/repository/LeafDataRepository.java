package com.example.plantdiseasedetection.repository;

import com.example.plantdiseasedetection.entity.LeafData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface LeafDataRepository extends JpaRepository<LeafData, Long> {

    List<LeafData> findAllByFruitIdAndDiseaseId(Long fruitId, Long diseaseId);

    Optional<LeafData> findByFruitIdAndDiseaseIdAndLeafConditionId(Long fruitId, Long diseaseId, Long leafConditionId);

}
