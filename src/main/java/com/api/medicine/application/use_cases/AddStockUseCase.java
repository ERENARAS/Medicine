package com.api.medicine.application.use_cases;

import com.api.medicine.domain.entities.ATM;
import com.api.medicine.domain.entities.PharmacyStaff;
import com.api.medicine.domain.interfaces.ATMRepository;
import com.api.medicine.domain.interfaces.User;
import com.api.medicine.domain.interfaces.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // YENİ: Atomik işlemler için
import java.util.Map;
import java.util.Optional;

@Service
public class AddStockUseCase {
    private final ATMRepository atmRepository;
    private final UserRepository userRepository;

    public AddStockUseCase(ATMRepository atmRepository, UserRepository userRepository) {
        this.atmRepository = atmRepository;
        this.userRepository = userRepository;
    }

    @Transactional // Veritabanı işlemlerinin başarılı/başarısız olma durumunu yönetir.
    public boolean execute(String staffEmail, Long atmId, String medicineName, int quantity) {

        Optional<User> staffOpt;
        staffOpt = userRepository.findByEmail(staffEmail);
        if (staffOpt.isEmpty() || !(staffOpt.get() instanceof PharmacyStaff)) {
            // Eczacı bulunamadı veya yetkisi yok
            return false;
        }
        PharmacyStaff staff = (PharmacyStaff) staffOpt.get();

        ATM atm = atmRepository.findById(atmId).orElse(null); // ATMRepository'de findById olduğunu varsayıyoruz
        if (atm == null) {
            return false;
        }

        // 3. İş Kuralı: Eczacının bu ATM'den sorumlu olup olmadığını kontrol et
        if (!atm.getResponsibleStaff().getEmail().equals(staff.getEmail())) {
            // Eczacı bu ATM'den sorumlu değil.
            return false;
        }

        Map<String, Integer> stock = atm.getStock();
        stock.put(medicineName, stock.getOrDefault(medicineName, 0) + quantity);

        atmRepository.save(atm); // JpaRepository'nin save metodunu kullanıyoruz
        return true;
    }
}