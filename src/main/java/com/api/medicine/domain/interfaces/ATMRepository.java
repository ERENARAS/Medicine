package com.api.medicine.domain.interfaces;

import com.api.medicine.domain.entities.ATM;

import java.util.Optional;

/**
 * ATMRepository arayüzü, ATM stok verilerinin kalıcı ortamla etkileşimini
 * tanımlar. Uygulamadaki ATM nesnesini yükleme ve kaydetme işlemleri bu
 * arayüz üzerinden gerçekleştirilir.
 */
public interface ATMRepository {
     ATM load();
     void saveATM(ATM atm);
     Optional<ATM> findById(Long id);
     ATM save(ATM atm);
}
