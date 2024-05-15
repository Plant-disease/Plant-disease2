package com.example.plantdiseasedetection.entity;

import com.example.plantdiseasedetection.entity.templete.AbsLongEntity;
import com.example.plantdiseasedetection.utils.TableNameConstant;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;

// BU CLASS MEVA YOKI SABZAVOT TURI (KARTOSHKA, POMIDOR, SABZI )

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = TableNameConstant.FRUIT)
@SQLDelete(sql = "UPDATE " + TableNameConstant.FRUIT + " SET deleted=true WHERE id=?")
@Where(clause = "deleted = false")
public class Fruit extends AbsLongEntity {

    private String name;   // MEVA YOKI SABZAVOT NOMI ( KARTOSHKA, POMIDOR, SABZI )

}
