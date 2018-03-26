package com.example.db;

import com.example.common.Util;
import org.sqlite.javax.SQLiteConnectionPoolDataSource;

public enum ConnectionPoolHelper {
    INSTANCE;

    private final SQLiteConnectionPoolDataSource dataSource = new SQLiteConnectionPoolDataSource();

    ConnectionPoolHelper() {
        dataSource.setUrl(Util.JDBC_URL);
        dataSource.getConfig().setKey("pass123");
    }

    public static ConnectionPoolHelper getInstance() {
        return INSTANCE;
    }

    public SQLiteConnectionPoolDataSource getDataSource() {
        return dataSource;
    }
}
