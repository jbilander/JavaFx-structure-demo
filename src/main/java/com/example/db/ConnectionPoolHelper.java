package com.example.db;

import com.creang.puddle.MiniConnectionPoolManager;
import com.example.common.Util;
import org.sqlite.javax.SQLiteConnectionPoolDataSource;

public enum ConnectionPoolHelper {
    INSTANCE;

    private SQLiteConnectionPoolDataSource dataSource = new SQLiteConnectionPoolDataSource();
    private MiniConnectionPoolManager miniConnectionPoolManager = MiniConnectionPoolManager.getInstance();

    ConnectionPoolHelper() {
        dataSource.setUrl(Util.JDBC_URL);
        dataSource.getConfig().setKey("pass123");
        miniConnectionPoolManager.setConnectionPoolDataSource(dataSource);
    }

    public static ConnectionPoolHelper getInstance() {
        return INSTANCE;
    }

    public MiniConnectionPoolManager getMiniConnectionPoolManager() {
        return miniConnectionPoolManager;
    }
}
