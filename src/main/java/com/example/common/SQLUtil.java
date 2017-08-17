package com.example.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLUtil {

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            //Todo logging
            System.out.println("An error occurred closing connection. " + e.getMessage());
        }
    }

    public static void closeStatement(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            //Todo logging
            System.out.println("An error occurred closing statement. " + e.getMessage());
        }
    }

    public static void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            //Todo logging
            System.out.println("An error occurred closing result set. " + e.getMessage());
        }
    }
}
