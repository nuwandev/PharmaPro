package com.nuwandev.pharmapro.config;

import org.flywaydb.core.Flyway;

import javax.sql.DataSource;

public class FlywayConfig {
    private FlywayConfig() {
        /* This utility class should not be instantiated */
    }

    public static void migrate(DataSource dataSource) {
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:db/migration")
                .load();

        flyway.migrate();
    }
}