package com.enviosexpress.tracking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private static final String URL = "jdbc:postgresql://localhost:5432/enviosexpress_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "qwerty123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
