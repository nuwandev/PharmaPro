package com.nuwandev.pharmapro.session;

import java.io.*;
import java.nio.file.*;

public class SessionStorage {

    private static final Path PATH =
            Paths.get(System.getProperty("user.home"), ".pharmapro", "session.txt");

    public static void save(String username) {
        try {
            Files.createDirectories(PATH.getParent());
            Files.writeString(PATH, username);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String load() {
        try {
            if (Files.exists(PATH)) {
                return Files.readString(PATH);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void clear() {
        try {
            Files.deleteIfExists(PATH);
        } catch (IOException ignored) {}
    }
}