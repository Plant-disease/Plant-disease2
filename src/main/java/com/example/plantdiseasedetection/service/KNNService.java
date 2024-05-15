package com.example.plantdiseasedetection.service;

import com.example.plantdiseasedetection.entity.LeafMeasurement;

import java.util.List;

public interface KNNService {

    List<Long> checkDiseaseByKNN(List<LeafMeasurement> leafMeasurementList, Long fruitId, Long diseaseId);

}