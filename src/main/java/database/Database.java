package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private Connection conn;


    public Database() {
        try {
            //load the MYSQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Connect to database
            String url = "jdbc:mysql://localhost:3306/databasesalon";
            String user = "root";
            String password = "root";
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
