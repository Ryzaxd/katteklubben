package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private Connection conn;


    public Database() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/kattebase";
            String user = "root";
            String password = "trUvaj2wQw1";
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("Connected to database");
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load JDBC driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Failed to connect to databsae: " + e.getMessage());;
        }
    }

    public Connection getConnection() {
        return conn;
    }
}
