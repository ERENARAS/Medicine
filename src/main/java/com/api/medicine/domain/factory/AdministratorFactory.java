package com.api.medicine.domain.factory;

import com.api.medicine.domain.entities.SystemAdministrator;
import com.api.medicine.domain.interfaces.User;

public class AdministratorFactory implements UserFactory{
    @Override
    public User createUser(String name) {
        return new SystemAdministrator(name);
    }
}
