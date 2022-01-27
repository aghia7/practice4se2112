package data.postgres;

import data.DB;

import java.sql.*;

public class Postgres implements DB {
    private Connection conn;

    public Postgres() {
        String connectionUrl = "jdbc:postgresql://localhost:5432/simpleappdb";

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(connectionUrl, "postgres", "0000");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("The driver for postgres cannot be found: " + e.getMessage());
        }
    }

    @Override
    public Connection getConnection() {
        return conn;
    }

    @Override
    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Cannot close the connection: " + e.getMessage());
        }
    }
}
