package com.example.katteklubben;

import Database.Database;

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

    public void check_login(String bruger_email, String password) {
        try {
            String sql = "SELECT bruger_email FROM bruger WHERE bruger_email = ?, AND password = ?";
            PreparedStatement statement = connector.getConnection().prepareStatement(sql);

            statement.setString(1, bruger_email);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();
            //Checks if rs returns
            if(rs.next()) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed.");
            }
            //Close connection
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
