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

        String url = value(dotenv, "DB_URL");
        String user = value(dotenv, "DB_USER");
        String pass = value(dotenv, "DB_PASSWORD");

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(pass);
        config.setDriverClassName("org.postgresql.Driver");
        config.setMaximumPoolSize(10);

        return new HikariDataSource(config);
    }

    private static String value(Dotenv dotenv, String key) {
        String envValue = dotenv.get(key);
        if (envValue == null || envValue.isBlank()) {
            throw new IllegalStateException(
                    "Required environment variable '"
                            + key
                            + "' is missing or empty. Application cannot start.");
        }
        return envValue;
    }
}
