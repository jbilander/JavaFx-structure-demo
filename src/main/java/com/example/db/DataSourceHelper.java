package com.example.db;

import com.example.common.Util;
import org.sqlite.SQLiteDataSource;

public enum DataSourceHelper {
    INSTANCE;

    private SQLiteDataSource dataSource = new SQLiteDataSource();

    DataSourceHelper() {
        dataSource.setUrl(Util.JDBC_URL);
        dataSource.getConfig().enforceForeignKeys(true);
    }

    public static DataSourceHelper getInstance() {
        return INSTANCE;
    }

    public SQLiteDataSource getDataSource() {
        return dataSource;
    }
}
