package com.nuwandev.pharmapro.session;

import com.nuwandev.pharmapro.model.User;

public class SessionContext {
    private static User currentUser;

    private SessionContext() {
        /* This utility class should not be instantiated */
    }

    public static User getUser() {
        return currentUser;
    }

    public static void setUser(User user) {
        currentUser = user;
    }

    public static void clear() {
        currentUser = null;
    }

    public static boolean isLoggedIn() {
        return currentUser != null;
    }
}