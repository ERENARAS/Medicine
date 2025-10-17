package com.api.medicine.domain.interfaces;

import com.api.medicine.domain.entities.Patient;

import java.util.Optional;

/**
 * UserRepository arayüzü, uygulamadaki kullanıcı User varlıklarının
 * kalıcı depolama ile etkileşimini tanımlar. Kullanıcı ekleme, okuma,
 * varlık kontrolü ve kimlik doğrulama işlemleri bu arayüz üzerinden
 * gerçekleştirilir.
 */
public interface UserRepository {
    boolean save(User user);

    Optional<Patient> findByEmail(String email);

    boolean existsByEmail(String email);
}
