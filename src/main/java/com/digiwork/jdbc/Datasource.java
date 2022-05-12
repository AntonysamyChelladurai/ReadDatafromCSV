package com.digiwork.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Datasource {
    private final String url = "jdbc:postgresql://localhost/training";
    private final String user = "postgres";
    private final String password = "indra123";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            System.out.println("Connection Details :: "+conn.toString());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }



}
