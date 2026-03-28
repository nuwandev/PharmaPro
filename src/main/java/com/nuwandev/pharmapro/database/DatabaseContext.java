package com.nuwandev.pharmapro.database;

import javax.sql.DataSource;

public final class DatabaseContext {
    private static DataSource dataSource;

    private DatabaseContext() {
    }

    public static DataSource getDataSource() {
        if (dataSource == null) {
            throw new IllegalStateException("DataSource not initialized");
        }
        return dataSource;
    }

    public static void setDataSource(DataSource ds) {
        dataSource = ds;
    }
}