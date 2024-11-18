package com.epam.aicode.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public final class DBUtils {

    private static final String CREATE_EMPLOYEE_TABLE_SQL = "CREATE TABLE employee (id INT PRIMARY KEY, name VARCHAR(255))";
    private static final String INSERT_INTO_EMPLOYEE_TABLE_SQL = "INSERT INTO employee (id, name) VALUES (?, ?)";
    private static final String DROP_EMPLOYEE_TABLE_SQL = "DROP TABLE employee";
    private static final String H2_DRIVER = "org.h2.Driver";
    private static final String NAME = "Name";
    private static final String URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";

    private DBUtils() {
    }

    public static Connection createDBConnection() {
        try {
            Class.forName(H2_DRIVER);
            return DriverManager.getConnection(URL, USER, "");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Exception during DB connection");
        }
    }

    public static void insertDataIntoEmployeeTable(Connection connection) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_EMPLOYEE_TABLE_SQL)) {
            for (int i = 1; i <= 1000000; i++) {
                preparedStatement.setInt(1, i);
                preparedStatement.setString(2, NAME + i);
                preparedStatement.addBatch();
                if (i % 1000000 == 0) {
                    preparedStatement.executeBatch();
                }
            }
        }
    }

    public static void dropEmployeeTable(final Statement statement) {
        try {
            statement.execute(DROP_EMPLOYEE_TABLE_SQL);
        } catch (SQLException e) {
            throw new RuntimeException("Exception when dropping employee table: " + e.getMessage(), e);
        }
    }

    public static void createEmployeeTable(Statement statement) throws SQLException {
        statement.execute(CREATE_EMPLOYEE_TABLE_SQL);
    }


}
