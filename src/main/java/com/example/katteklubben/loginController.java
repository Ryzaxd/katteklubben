package com.example.katteklubben;


import database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginController {

    private Database connector;
    private Connection connection;

    public loginController() {
        connector = new Database();
        connection = connector.getConnection();
    }

    public void check_login(String email, String password) {
        try {
            String sql = "SELECT email FROM medlem WHERE email = ?, AND password = ?";
            PreparedStatement statement = connector.getConnection().prepareStatement(sql);

            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();

            if(rs.next()) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed.");
            }

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
