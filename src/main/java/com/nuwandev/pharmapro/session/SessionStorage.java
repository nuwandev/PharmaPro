package com.nuwandev.pharmapro.session;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class SessionStorage {
    private static final Logger LOGGER = Logger.getLogger(SessionStorage.class.getName());
    private static final Path PATH =
            Paths.get(System.getProperty("user.home"), ".pharmapro", "session.txt");

    private SessionStorage() {
        /* Utility class: prevent instantiation */
    }

    public static String load() {
        try {
            if (Files.exists(PATH)) {
                return Files.readString(PATH);
            }
        } catch (IOException e) {
            LOGGER.warning("Failed to load session: " + e.getMessage());
        }
        return null;
    }

    public static void clear() {
        try {
            Files.deleteIfExists(PATH);
        } catch (IOException e) {
            LOGGER.fine("Session file did not exist or could not be deleted: " + e.getMessage());
        }
    }

    public static void saveToken(String token) {
        try {
            Files.createDirectories(PATH.getParent());
            Files.writeString(PATH, token);
        } catch (IOException e) {
            LOGGER.warning("Failed to save token: " + e.getMessage());
        }
    }

    public static String loadToken() {
        // For now, just call load() for DRY principle
        return load();
    }
}
