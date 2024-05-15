package com.example.plantdiseasedetection.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LeafDataDTO {

    private double sum;
    private Long leafConditionId;

}
