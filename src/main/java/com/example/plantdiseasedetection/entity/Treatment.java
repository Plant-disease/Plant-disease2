package com.example.plantdiseasedetection.entity;

import com.example.plantdiseasedetection.entity.templete.AbsLongEntity;
import com.example.plantdiseasedetection.utils.TableNameConstant;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

//BU CLASS KASALLIK ANIQLANGAN MEVAGA SHU KASALLIKGA QARSHI INSTRUKSIYALAR KO'RSATISH UCHUN
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity(name = TableNameConstant.Treatment)
@SQLDelete(sql = "UPDATE " + TableNameConstant.Treatment + " SET deleted=true WHERE id=?")
@Where(clause = "deleted = false")
public class Treatment extends AbsLongEntity {

    private String instruction;   // INSTRUKTSIYA

    @OneToOne
    private LeafCondition leafCondition;  // BARG HOLATI(1-DARAJALI KASALLANISH ,2-DARAJALI KASALLANISH)
}
