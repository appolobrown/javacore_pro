package ru.geekbrains.javacore.lesson2;

import java.sql.*;

public class SQLConnection {

    private Connection connection;
    private Statement stmt;
    private PreparedStatement pstmt;

    private void connect() throws Exception {
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = connection.createStatement();
    }

    private void disconnect() throws SQLException {
        connection.close();
    }
}
