package com.epam.aicode.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectionManager {

    private String url;
    private String username;
    private String password;
    private Connection connection;

    public DatabaseConnectionManager(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection connect() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }

    public void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public ResultSet executeQuery(String query) throws SQLException {
        if (!isConnected()) {
            connect();
        }
        Statement statement = connection.createStatement();
        if (statement == null) {
            throw new SQLException("Failed to create statement.");
        }
        return statement.executeQuery(query);
    }

    private boolean isConnected() throws SQLException {
        return connection != null && !connection.isClosed();
    }
}