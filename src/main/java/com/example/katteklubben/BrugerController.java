package com.example.katteklubben;

import Database.Database;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BrugerController {

    private Database connector;
    private Connection connection;

    public boolean opret_bruger(String bruger_navn, String bruger_email, String bruger_password) {
        try {
            String sql = "INSERT INTO bruger (Bruger_navn, Bruger_email, Bruger_password) VALUES (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, bruger_navn);
            statement.setString(2,bruger_navn);
            statement.setString(3,bruger_password);

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
