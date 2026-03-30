package com.nuwandev.pharmapro.config;

import org.flywaydb.core.Flyway;

import javax.sql.DataSource;

public final class FlywayConfig {
    private FlywayConfig() {
    }

    public static void migrate(DataSource dataSource) {
        Flyway.configure().dataSource(dataSource).locations("classpath:db/migration").load().migrate();
    }
}
