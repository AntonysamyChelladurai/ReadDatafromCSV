package com.digiwork.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Datasource {

    private static Datasource instance;
    private final String url = "jdbc:postgresql://localhost/training";
    private final String user = "postgres";
    private final String password = "indra123";

    private Connection conn = null;

    public Datasource()  {
        try {
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Connected to the PostgreSQL server successfully.");
        System.out.println("Connection Details :: "+conn.toString());
    }
    public Datasource getInstance() throws SQLException {
        if(instance == null) {
            synchronized(Datasource.class) {
                if (instance == null){
                    instance = new Datasource();
            }
             else if (instance.getConnection().isClosed()) {
                instance = new Datasource();
            }
        }
        }
        return instance;
    }

    public Connection getConnection() {
        return conn;
    }
}
