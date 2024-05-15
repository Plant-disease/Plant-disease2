package com.example.plantdiseasedetection.repository;

import com.example.plantdiseasedetection.entity.LeafCondition;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LeafConditionRepository extends JpaRepository<LeafCondition, Long> {

    Boolean existsByName(String name);
    Boolean existsByNameAndIdNot(String name,Long id);
}
