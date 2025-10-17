package com.api.medicine.application.use_cases;

import com.api.medicine.domain.entities.ATM;
import com.api.medicine.domain.interfaces.ATMRepository;
import java.util.Map;

public class AddStockUseCase {
    private final ATMRepository atmRepository;
    public AddStockUseCase(ATMRepository atmRepository) {
        this.atmRepository = atmRepository;
    }

    public void execute(String medicineName, int quantity) {
        ATM atm = atmRepository.load();
        Map<String, Integer> stock = atm.getStock();
        stock.put(medicineName, stock.getOrDefault(medicineName, 0) + quantity);
        atmRepository.saveATM(atm);
        System.out.println(medicineName + " stoğa eklendi: +" + quantity);
    }
}
