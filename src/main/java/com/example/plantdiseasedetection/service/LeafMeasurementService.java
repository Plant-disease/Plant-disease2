package com.example.plantdiseasedetection.service;

import com.example.plantdiseasedetection.entity.Attachment;
import com.example.plantdiseasedetection.entity.LeafData;
import com.example.plantdiseasedetection.entity.LeafMeasurement;

import java.util.List;

public interface LeafMeasurementService {

    List<LeafMeasurement> getLeafMeasurementToSaveDB(LeafData leafData, List<Attachment> attachmentList);

    List<LeafMeasurement> getLeafMeasurementToCheckKNN(List<Attachment> attachmentList);
}
