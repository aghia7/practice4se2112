package data.mysql;

import data.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL implements DB {
    private Connection conn;

    public MySQL() {
        String connectionUrl = "jdbc:mysql://localhost:3306/dbname";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connectionUrl, "username", "pwd");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("The driver for mysql cannot be found: " + e.getMessage());
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
