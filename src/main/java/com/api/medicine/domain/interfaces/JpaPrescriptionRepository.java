package com.api.medicine.domain.interfaces;

import com.api.medicine.domain.entities.Patient;
import com.api.medicine.domain.entities.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaPrescriptionRepository extends JpaRepository<Prescription, Long>, PrescriptionRepository {
    Optional<List<Prescription>> findByPatient(Patient patient);

}
