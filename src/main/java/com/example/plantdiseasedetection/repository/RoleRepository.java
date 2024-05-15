package com.example.plantdiseasedetection.repository;

import com.example.plantdiseasedetection.entity.Role;
import com.example.plantdiseasedetection.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByType(RoleType roleType);

    List<Role> findAllByTypeNot(RoleType roleType);
}
