package com.example.plantdiseasedetection.repository;

import com.example.plantdiseasedetection.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FruitRepository extends JpaRepository<Fruit, Long> {

    Boolean existsByName(String name);
    Boolean existsByNameAndIdNot(String name,Long id);
}
