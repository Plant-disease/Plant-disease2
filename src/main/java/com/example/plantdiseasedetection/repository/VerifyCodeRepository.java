package com.example.plantdiseasedetection.repository;


import com.example.plantdiseasedetection.entity.VerifyCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface VerifyCodeRepository extends JpaRepository<VerifyCode, UUID> {

    long countAllByPhoneNumberAndCreatedAtAfter(String phoneNumber, Timestamp after);
    long countAllByEmailAndCreatedAtAfter(String email, Timestamp after);

    Optional<VerifyCode> findFirstByPhoneNumberAndConfirmedIsFalseAndCreatedAtAfterOrderByCreatedAtDesc(String phoneNumber, Timestamp createdAt);
    Optional<VerifyCode> findFirstByEmailAndConfirmedIsFalseAndCreatedAtAfterOrderByCreatedAtDesc(String email, Timestamp createdAt);

    Optional<VerifyCode> findFirstByPhoneNumberAndCodeAndConfirmedIsTrueOrderByCreatedAtDesc(String phoneNumber, String code);
    Optional<VerifyCode> findFirstByEmailAndCodeAndConfirmedIsTrueOrderByCreatedAtDesc(String email, String code);

}
