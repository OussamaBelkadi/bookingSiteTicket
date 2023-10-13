package com.example.fly.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Connection connection;
    private Database(){

    }
    static {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/FLy";
        String username = "postgres";
        String password = "Os12";

        try {
             connection = DriverManager.getConnection(jdbcUrl, username, password);
            // Use the 'connection' for database operations.
            // Don't forget to close the connection when you're done.
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getInstance(){
        return connection;
    }
    public static void deconnect(){
        try {
            if (connection !=null) connection.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
