package com.api.medicine.domain.interfaces;

import com.api.medicine.domain.entities.ATM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaATMRepository extends JpaRepository<ATM, Long>, ATMRepository {

}
