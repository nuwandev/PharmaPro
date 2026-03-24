package com.nuwandev.pharmapro.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.github.cdimascio.dotenv.Dotenv;

import javax.sql.DataSource;

public final class DataSourceConfig {
    private DataSourceConfig() {
    }

    public static DataSource create() {
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

        String url = value(dotenv, "DB_URL", "jdbc:postgresql://localhost:5432/pharmapro");
        String user = value(dotenv, "DB_USER", "postgres");
        String pass = value(dotenv, "DB_PASSWORD", "password");

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(pass);
        config.setDriverClassName("org.postgresql.Driver");
        config.setMaximumPoolSize(10);

        return new HikariDataSource(config);
    }

    private static String value(Dotenv dotenv, String key, String fallback) {
        String envValue = dotenv.get(key);
        return (envValue == null || envValue.isBlank()) ? fallback : envValue;
    }
}