package com.example.katteklubben;

import database.Database;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BrugerController {

    private Database connector;
    private Connection connection;

    public boolean opret_bruger(String fnavn,String enavn, String email, String password) {
        try {
            String sql = "INSERT INTO medlem (fnavn, enavn, email, password) VALUES (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, fnavn);
            statement.setString(2, enavn);
            statement.setString(3, email);
            statement.setString(4,password);

            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
