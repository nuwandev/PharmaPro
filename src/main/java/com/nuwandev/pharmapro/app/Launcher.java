package com.nuwandev.pharmapro.app;

import javafx.application.Application;

public class Launcher {
    public static void main(String[] args) {
        AppBootstrap.init();
        Application.launch(PharmaProApplication.class, args);
    }
}
