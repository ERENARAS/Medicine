package com.api.medicine.domain.interfaces;

import com.api.medicine.domain.entities.ATM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaATMRepository extends JpaRepository<ATM, Long>, ATMRepository {
    default ATM loadATM() {
        // PostgreSQL'de tek bir ATM'yi (ID=1L varsayımıyla) çekmek için JpaRepository metodu kullanılır.
        return findById(1L).orElse(null); // veya özel bir exception fırlatılabilir.
    }
}
