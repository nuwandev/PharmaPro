package com.nuwandev.pharmapro.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.github.cdimascio.dotenv.Dotenv;

import javax.sql.DataSource;

public class DataSourceConfig {
    private DataSourceConfig() {
        /* This utility class should not be instantiated */
    }

    public static DataSource create() {
        HikariConfig config = new HikariConfig();

        Dotenv dotenv = Dotenv.load();
        String dbUrl = dotenv.get("DB_URL");
        String dbUser = dotenv.get("DB_USER");
        String dbPassword = dotenv.get("DB_PASSWORD");

        config.setJdbcUrl(dbUrl);
        config.setUsername(dbUser);
        config.setPassword(dbPassword);

        return new HikariDataSource(config);
    }
}
