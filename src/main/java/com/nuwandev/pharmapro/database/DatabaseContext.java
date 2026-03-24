package com.nuwandev.pharmapro.database;

import javax.sql.DataSource;

public class DatabaseContext {
    private DatabaseContext() {
        /* This utility class should not be instantiated */
    }

    private static DataSource dataSource;

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static void setDataSource(DataSource ds) {
        dataSource = ds;
    }
}

