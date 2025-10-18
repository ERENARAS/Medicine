package com.api.medicine.domain.interfaces;

import com.api.medicine.domain.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<Patient, Long>, UserRepository {

    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
