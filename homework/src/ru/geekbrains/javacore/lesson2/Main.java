package ru.geekbrains.javacore.lesson2;

import ru.geekbrains.javacore.lesson2.db.SQLiteDatabase;

import java.sql.*;

public class Main {

    public static final String DBNAME = "newone.db";
    public static final String TABLE = "students";


    public static void main(String[] args) {
        SQLiteDatabase database = new SQLiteDatabase(DBNAME);
        try {
            database.connect();
            database.createTable(TABLE);
            database.insert(TABLE, "John", 120);
            database.insert(TABLE, "John2", 130);
            database.insert(TABLE, "John3", 140);
            System.out.println(database.getByName(TABLE, "name", "John"));
            database.update(TABLE, "John2", 111);
            System.out.println(database.getByName(TABLE, "name", "John2"));
            database.delete(TABLE, "John2");
            database.dropTable(TABLE);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


}
