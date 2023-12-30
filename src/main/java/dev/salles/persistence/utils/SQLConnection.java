package dev.salles.persistence.utils;

import java.sql.*;

public class SQLConnection {
    private static final String url = "jdbc:mysql://localhost/thesocialmedia";
    private static final String user = "youruser";
    private static final String password = "yourpassword";
    private static Connection conn;

    public static Connection getConn() {
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            } else {
                return conn;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}