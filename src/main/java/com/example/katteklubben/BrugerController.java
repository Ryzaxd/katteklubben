package com.example.katteklubben;

import database.Database;
import klasser.Medlem;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BrugerController {

    private Database connector;
    private Connection connection;

    public boolean opret_bruger(String fnavn,String enavn, String email, String password) {
        try {
            String sql = "INSERT INTO medlem (fnavn, enavn, email, password) VALUES (?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, fnavn);
            statement.setString(2, enavn);
            statement.setString(3, email);
            statement.setString(4, password);

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

    public ArrayList<Medlem> slå_alle_medlemmer_op() {

        ArrayList<Medlem> medlemList = new ArrayList<>();

        try {
            String sql = "SELECT * from medlem";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                Medlem medlem = new Medlem();
                medlem.setMid(rs.getInt("mid"));
                medlem.setFnavn(rs.getString("fnavn"));
                medlem.setEnavn(rs.getString("enavn"));
                medlem.setEmail(rs.getString("email"));

                medlemList.add(medlem);
            }

            rs.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return medlemList;
    }


}
