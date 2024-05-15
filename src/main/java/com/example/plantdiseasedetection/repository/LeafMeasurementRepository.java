package com.example.plantdiseasedetection.repository;

import com.example.plantdiseasedetection.entity.LeafMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LeafMeasurementRepository extends JpaRepository<LeafMeasurement, Long> {

}
