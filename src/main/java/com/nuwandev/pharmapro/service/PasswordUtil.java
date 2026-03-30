package com.nuwandev.pharmapro.service;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {
    private static final int LOG_ROUNDS = 12;

    public static String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(LOG_ROUNDS));
    }

    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        if (plainPassword == null || hashedPassword == null) return false;
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }

    // For manual hash generation
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java PasswordUtil <plainPassword>");
            return;
        }
        String hash = hashPassword(args[0]);
        System.out.println("BCrypt hash: " + hash);
    }
}
