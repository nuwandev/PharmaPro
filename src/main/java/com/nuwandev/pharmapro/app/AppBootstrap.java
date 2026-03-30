package com.nuwandev.pharmapro.app;

import com.nuwandev.pharmapro.config.DataSourceConfig;
import com.nuwandev.pharmapro.config.FlywayConfig;
import com.nuwandev.pharmapro.database.DatabaseContext;

import javax.sql.DataSource;

public final class AppBootstrap {
    private static boolean initialized = false;

    private AppBootstrap() {
    }

    public static synchronized void init() {
        if (initialized) return;

        DataSource dataSource = DataSourceConfig.create();
        FlywayConfig.migrate(dataSource);
        DatabaseContext.setDataSource(dataSource);

        initialized = true;
    }
}
