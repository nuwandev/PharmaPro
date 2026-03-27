package com.nuwandev.pharmapro.factory;

import com.nuwandev.pharmapro.database.DatabaseContext;
import com.nuwandev.pharmapro.repository.UserRepository;
import com.nuwandev.pharmapro.service.AuthService;

public class ServiceFactory {
    private static UserRepository userRepository;
    private static AuthService authService;

    private ServiceFactory() {
    }

    public static synchronized AuthService authService() {
        if (authService == null) {
            if (userRepository == null) {
                userRepository = new UserRepository(DatabaseContext.getDataSource());
            }
            authService = new AuthService(userRepository);
        }
        return authService;
    }

}
