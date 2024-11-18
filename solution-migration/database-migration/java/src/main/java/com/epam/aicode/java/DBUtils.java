package com.epam.aicode.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class DBUtils {

    private static final String CREATE_USER_TABLE_SQL = "CREATE TABLE user (id INT PRIMARY KEY, name VARCHAR(255))";
    private static final String H2_DRIVER = "org.h2.Driver";

    private DBUtils() {
    }

    public static Connection createDBConnection(String url, String user, String password) {
        try {
            Class.forName(H2_DRIVER);
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Exception during DB connection");
        }
    }

    public static void insertUsersIntoUserTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO user (id, name) VALUES (1, 'Name1')");
        statement.execute("INSERT INTO user (id, name) VALUES (2, 'Name2')");
    }

    public static void createUserTable(Statement statement) throws SQLException {
        statement.execute(CREATE_USER_TABLE_SQL);
    }
}
