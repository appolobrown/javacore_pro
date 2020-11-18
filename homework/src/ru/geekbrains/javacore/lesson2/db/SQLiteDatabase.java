package ru.geekbrains.javacore.lesson2.db;

import java.io.Closeable;
import java.sql.*;

public class SQLiteDatabase implements Closeable {

    private final String URL;
    private Connection connection;
    private Statement stmt;
    private PreparedStatement pstmt;

    public SQLiteDatabase(String dbname) {
        URL = "jdbc:sqlite:" + dbname;
    }

    public void connect() throws SQLException {
        connection = DriverManager.getConnection(URL);
        stmt = connection.createStatement();
    }

    public void createTable(String table) throws SQLException {
        stmt.execute("CREATE TABLE IF NOT EXISTS " + table +
                " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "score INTEGER)");
    }

    public void dropTable(String table) throws SQLException {
        stmt.execute("DROP TABLE " + table);
    }

    public int insert(String table, String name, int score) throws SQLException {
        pstmt = connection.prepareStatement("INSERT INTO " + table + " (name, score) values (?, ?);");
        pstmt.setString(1, name);
        pstmt.setInt(2, score);
        return pstmt.executeUpdate();
    }

    public String getByName(String table, String columnName, String name) throws SQLException {
        pstmt = connection.prepareStatement("SELECT * FROM " + table + " WHERE " + columnName + " = ?");
        pstmt.setString(1, name);
        ResultSet resultSet = pstmt.executeQuery();
        StringBuilder stringBuilder = new StringBuilder("{ " + name + " = {");
        while (resultSet.next()) {
            stringBuilder.append("id=" + resultSet.getInt("id") + ",")
                    .append("name=" + resultSet.getString("name") + ",")
                    .append("score=" + resultSet.getString("score") + "}");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void update(String table, String name, int score) throws SQLException {
        pstmt = connection.prepareStatement("UPDATE " + table + " SET name = ? , "
                + "score = ? "
                + "WHERE name = ?");
        pstmt.setString(1, name);
        pstmt.setInt(2, score);
        pstmt.setString(3, name);
        pstmt.executeUpdate();
    }

    public void delete(String table, String name) throws SQLException {
        pstmt = connection.prepareStatement("DELETE FROM " + table + " WHERE name = ?");
        pstmt.setString(1, name);
        pstmt.executeUpdate();
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
