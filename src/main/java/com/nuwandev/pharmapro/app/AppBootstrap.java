package com.nuwandev.pharmapro.app;

import com.nuwandev.pharmapro.config.DataSourceConfig;
import com.nuwandev.pharmapro.config.FlywayConfig;
import com.nuwandev.pharmapro.database.DatabaseContext;

import javax.sql.DataSource;

public class AppBootstrap {
    private AppBootstrap() {
        /* This utility class should not be instantiated */
    }

    public static void init() {
        DataSource dataSource = DataSourceConfig.create();
        FlywayConfig.migrate(dataSource);
        DatabaseContext.setDataSource(dataSource);
    }
}
